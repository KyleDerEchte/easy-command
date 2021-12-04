package de.kyleonaut.easycommand.command;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import java.util.Arrays;

/**
 * @author kyleonaut
 * @version 1.0.0
 * created at 04.12.2021
 */
public abstract class EasyCommandExecutor extends BukkitCommand {

    public EasyCommandExecutor(String name) {
        super(name);
        this.description = getClass().getAnnotation(EasyCommand.class).description();
        this.setAliases(Arrays.asList(getClass().getAnnotation(EasyCommand.class).aliases()));
        this.setPermission(getClass().getAnnotation(EasyCommand.class).permission());
    }

    public boolean execute(CommandSender sender, String[] args) {
        return false;
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        return execute(commandSender, strings);
    }
}
