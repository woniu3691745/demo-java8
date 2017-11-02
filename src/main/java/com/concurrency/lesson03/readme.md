###重入锁（Reentrant lock）
> 重入锁可以玩全替代synchronized,与synchronized相比有着显示的操作过程。
 + lock()： 获得锁，如果锁已经被占用，则等待。
 + lockInterruptibly()：获得锁，但优先响应中断。
 + tryLock()：尝试获得锁，如果成功，返回true，失败返回false，该方法不等待，立即返回。
 + tryLock(long time, TimeUnit unit)：在给定时间内尝试获得锁。
 + unlock()：释放锁。 
 
###重入锁的好搭档（Condition）
> 在Condition.await()调用后，这个线程会释放这把锁。
> 在Condition.signal()方法调用时，也要求线程获得相关的锁。
 + await() 等待线程，释放锁，当线程被中断时，也能跳出等待。
 + signal() 唤醒一个等待的线程。
 + awaitUninterruptibly() 不会响应中断。
 
###允许多个线程同时访问：信号量（Semaphore）
> 信号量维多线程协作提供了更为强大的控制方法，信号量是对锁的扩展。
 + acquire() 获得一个许可，若无法获得，则线程会等待，知道有线程释放一个许可或者当前线程中断。
 + acquireUninterruptibly() 不响应中断。
 + tryAcquire() 有许可返回true，否则false，不会等待。
 + release() 线程资源访问结束后，释放一个许可。