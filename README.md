# easy-command
Annotation based command framework

Create a command executor
```java
@EasyCommand(name = "example", permission = "easycommand.example")
public class EasyCommandExampleCommand extends EasyCommandExecutor {
    public EasyCommandExampleCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        sender.sendMessage("Example Command!");
        return true;
    }
}
```
Register all commands
```java
    @Override
    public void onEnable() {
        try {
            EasyCommandAPI.register();
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
```
