package de.kyleonaut.easycommand.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author kyleonaut
 * @version 1.0.0
 * created at 04.12.2021
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EasyCommand {
    String name();

    String[] aliases() default "";

    String permission();

    String description() default "No description provided";
}
