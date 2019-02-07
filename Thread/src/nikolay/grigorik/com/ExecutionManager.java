package nikolay.grigorik.com;

public interface ExecutionManager {
    Context execute(Runnable callback, Runnable ... tasks);
}