package javacore.week4;

public interface RobotConnection extends AutoCloseable {
    String text ="RobotConnection";
    void moveRobotTo(int x, int y);
    @Override
    void close();
}
