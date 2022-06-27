package net.theiceninja.spawn.utils;

public enum MessageUtils {
    NOT_PLAYER("The console cannot use this command!"),
    NO_PERMS("You don't have permission to use this command!"),
    NO_SPAWN("There is no spawn set!"),
    PREFIX("&6[&aSpawn&6]&r "),
    PLAYER_ERR("Player not found!");

    final String message;

    MessageUtils(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

