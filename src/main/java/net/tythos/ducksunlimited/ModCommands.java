package net.tythos.ducksunlimited;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.text.MutableText;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.command.v2.ArgumentTypeRegistry;
import net.minecraft.util.Identifier;
import net.minecraft.command.argument.serialize.ConstantArgumentSerializer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.command.argument.RegistryEntryReferenceArgumentType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.command.suggestion.SuggestionProviders;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.util.Formatting;

public class ModCommands {
    private static int executeDedicatedCommand(CommandContext<ServerCommandSource> context) {
        context.getSource().sendFeedback(() -> Text.literal("Called /dedicated_command."), false);
        return 1;
    }

    private static int executeRequiredCommand(CommandContext<ServerCommandSource> context) {
        context.getSource().sendFeedback(() -> Text.literal("Called /required_command."), false);
        return 1;
    }

    private static int executeSubCommandOne(CommandContext<ServerCommandSource> context) {
        context.getSource().sendFeedback(() -> Text.literal("Called /command sub_command_one."), false);
        return 1;
    }

    private static int executeCommandTwo(CommandContext<ServerCommandSource> context) {
        context.getSource().sendFeedback(() -> Text.literal("Called /command_two."), false);
        return 1;
    }

    private static int executeSubCommandTwo(CommandContext<ServerCommandSource> context) {
        context.getSource().sendFeedback(() -> Text.literal("Called /sub_command_two."), false);
        return 1;
    }

    private static int executeRedirectedBy(CommandContext<ServerCommandSource> context) {
        context.getSource().sendFeedback(() -> Text.literal("Called /redirected_by."), false);
        return 1;
    }

    private static int executeCommandWithArg(CommandContext<ServerCommandSource> context) {
        int value = IntegerArgumentType.getInteger(context, "value");
        context.getSource()
                .sendFeedback(() -> Text.literal("Called /command_with_arg with value = %s".formatted(value)), false);
        return 1;
    }

    private static int executeWithOneArg(CommandContext<ServerCommandSource> context) {
        int value1 = IntegerArgumentType.getInteger(context, "value_one");
        context.getSource().sendFeedback(
                () -> Text.literal("Called /command_with_two_args with value one = %s".formatted(value1)), false);
        return 1;
    }

    private static int executeWithTwoArgs(CommandContext<ServerCommandSource> context) {
        int value1 = IntegerArgumentType.getInteger(context, "value_one");
        int value2 = IntegerArgumentType.getInteger(context, "value_two");
        context.getSource().sendFeedback(
                () -> Text
                        .literal("Called /argtater2 with value one = %s and value two = %s".formatted(value1, value2)),
                false);
        return 1;
    }

    private static int executeCommon(int value1, int value2, CommandContext<ServerCommandSource> context) {
        context.getSource().sendFeedback(() -> Text.literal(
                "Called /command_with_common_exec with value 1 = %s and value 2 = %s".formatted(value1, value2)),
                false);
        return 1;
    }

    private static int executeCustomArgCommand(CommandContext<ServerCommandSource> context) {
        BlockPos arg = context.getArgument("block_pos", BlockPos.class);
        context.getSource().sendFeedback(
                () -> Text.literal("Called /command_with_custom_arg with block pos = %s".formatted(arg)), false);
        return 1;
    }

    private static int executeCommandWithSuggestions(CommandContext<ServerCommandSource> context)
            throws CommandSyntaxException {
        var entityType = RegistryEntryReferenceArgumentType.getSummonableEntityType(context, "entity");
        context.getSource().sendFeedback(() -> Text.literal("Called /command_with_suggestions with entity = %s"
                .formatted(entityType.value().getUntranslatedName())), false);
        return 1;
    }

    private static int executeCommandWithCustomSuggestions(CommandContext<ServerCommandSource> context) {
        String name = StringArgumentType.getString(context, "player_name");
        context.getSource().sendFeedback(
                () -> Text.literal("Called /command_with_custom_suggestions with value = %s".formatted(name)), false);
        return 1;
    }

    protected static void initialize() {
        ducksunlimited.LOGGER.info("Registering {} commands", "ducksunlimited");
        ArgumentTypeRegistry.registerArgumentType(Identifier.of("ducksunlimited", "block_pos"),
                BlockPosArgumentType.class, ConstantArgumentSerializer.of(BlockPosArgumentType::new));
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("test_command").executes(context -> {
                context.getSource().sendFeedback(() -> Text.literal("Called /test_command."), false);
                return 1;
            }));
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            if (environment.dedicated) {
                dispatcher.register(
                        CommandManager.literal("dedicated_command").executes(ModCommands::executeDedicatedCommand));
            }
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("required_command")
                    .requires(source -> source.hasPermissionLevel(1)).executes(ModCommands::executeRequiredCommand));
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("command_one")
                    .then(CommandManager.literal("sub_command_one").executes(ModCommands::executeSubCommandOne)));
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("command_two").executes(ModCommands::executeCommandTwo)
                    .then(CommandManager.literal("sub_command_two").executes(ModCommands::executeSubCommandTwo)));
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            var redirectedBy = dispatcher
                    .register(CommandManager.literal("redirected_by").executes(ModCommands::executeRedirectedBy));
            dispatcher.register(CommandManager.literal("to_redirect").executes(ModCommands::executeRedirectedBy)
                    .redirect(redirectedBy));
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("command_with_arg").then(CommandManager
                    .argument("value", IntegerArgumentType.integer()).executes(ModCommands::executeCommandWithArg)));
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("command_with_two_args")
                    .then(CommandManager.argument("value_one", IntegerArgumentType.integer())
                            .executes(ModCommands::executeWithOneArg)
                            .then(CommandManager.argument("value_two", IntegerArgumentType.integer())
                                    .executes(ModCommands::executeWithTwoArgs))));
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("command_with_common_exec")
                    .then(CommandManager.argument("value_one", IntegerArgumentType.integer()).executes(
                            context -> executeCommon(IntegerArgumentType.getInteger(context, "value_one"), 0, context))
                            .then(CommandManager.argument("value_two", IntegerArgumentType.integer())
                                    .executes(context -> executeCommon(
                                            IntegerArgumentType.getInteger(context, "value_one"),
                                            IntegerArgumentType.getInteger(context, "value_two"), context)))));
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("command_with_custom_arg").then(CommandManager
                    .argument("block_pos", new BlockPosArgumentType()).executes(ModCommands::executeCustomArgCommand)));
        });

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("command_with_suggestions")
                    .then(CommandManager
                            .argument("entity",
                                    RegistryEntryReferenceArgumentType.registryEntry(registryAccess,
                                            RegistryKeys.ENTITY_TYPE))
                            .suggests(SuggestionProviders.SUMMONABLE_ENTITIES)
                            .executes(ModCommands::executeCommandWithSuggestions)));
        });

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("command_with_custom_suggestions")
                    .then(CommandManager.argument("player_name", StringArgumentType.string())
                            .suggests(new PlayerSuggestionProvider())
                            .executes(ModCommands::executeCommandWithCustomSuggestions)));
        });

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("text_and_translations").executes(context -> {
                Text literal = Text.of("Hello, world!");
                MutableText mutable = Text.literal("Hello, World!");
                Text mutableAsText = mutable;
                Text translatable = Text.translatable("ducksunlimited.text.hello");
                MutableText mutable2 = Text.translatable("ducksunlimited.text.bye");
                context.getSource().sendFeedback(() -> translatable, false);
                context.getSource().sendFeedback(
                        () -> mutable2.formatted(Formatting.AQUA, Formatting.BOLD, Formatting.UNDERLINE), false);
                return 1;
            }));
        });
    }
}
