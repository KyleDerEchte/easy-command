# easy-command api
Annotation based command framework

Create a command executor
```java
@EasyCommand(name = "example", permission = "easycommand.example")
public class EasyCommandExampleCommand extends EasyCommandExecutor {

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
        EasyCommandAPI.register();
    }
```
