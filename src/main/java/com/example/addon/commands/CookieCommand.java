package com.example.addon.commands;  // Keep this or update to your package

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;

public class CookieCommand extends Command {  // ← Changed from CommandExample
    public CookieCommand() {  // ← Changed from CommandExample
        super("cookie", "Sends a cookie message.");
    }

    @Override
    public void build(LiteralArgumentBuilder<ClientSuggestionProvider> builder) {
        builder.executes(_ -> {
            info("🍪 Here's a cookie!");
            return SINGLE_SUCCESS;
        });

        builder.then(literal("name").then(argument("nameArgument", StringArgumentType.word()).executes(context -> {
            String argument = StringArgumentType.getString(context, "nameArgument");
            info("🍪 Here's a cookie for " + argument + "!");
            return SINGLE_SUCCESS;
        })));
    }
}
