package com.yourname.cookieaddon;

import com.yourname.cookieaddon.modules.SwingSpeed;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieAddon extends MeteorAddon {
    public static final Logger LOG = LoggerFactory.getLogger("cookie-addon");
    public static final Category CATEGORY = new Category("Cookie Addon");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Cookie Addon");

        // Register the Swing Speed module
        Modules.get().add(new SwingSpeed());

        LOG.info("Cookie Addon initialized successfully!");
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "com.yourname.cookieaddon";
    }
}
