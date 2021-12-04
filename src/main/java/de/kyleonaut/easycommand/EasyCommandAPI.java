package de.kyleonaut.easycommand;

import de.kyleonaut.easycommand.command.EasyCommand;
import de.kyleonaut.easycommand.command.EasyCommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/**
 * @author kyleonaut
 * @version 1.0.0
 * created at 04.12.2021
 */
public class EasyCommandAPI {

    public static void register() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
        bukkitCommandMap.setAccessible(true);
        final CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

        final Reflections reflections = new Reflections();
        final Set<Class<? extends EasyCommandExecutor>> executors = reflections.getSubTypesOf(EasyCommandExecutor.class);
        for (Class<? extends EasyCommandExecutor> executor : executors) {
            final String commandName = executor.getAnnotation(EasyCommand.class).name();
            commandMap.register(
                    commandName,
                    executor.getConstructor(String.class).newInstance(commandName)
            );
        }
    }
}
