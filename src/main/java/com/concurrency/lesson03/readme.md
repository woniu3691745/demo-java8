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
> 信号量为多线程协作提供了更为强大的控制方法，信号量是对锁的扩展。
    无论是内部锁synchronized还是重入锁ReentrantLock，一次都只允许一个线程访问一个资源，
    而信号量却可以指定多个线程
 + acquire() 获得一个许可，若无法获得，则线程会等待，知道有线程释放一个许可或者当前线程中断。
 + acquireUninterruptibly() 不响应中断。
 + tryAcquire() 有许可返回true，否则false，不会等待。
 + release() 线程资源访问结束后，释放一个许可。
 
###读写锁（ReadWriteLock）
> 读写锁可以有效地帮助减少锁竞争
 + 读-读不互斥：读读之间不阻塞。
 + 读-写互斥：读阻塞写，写也会阻塞读。
 + 写-写互斥：写写阻塞。
 
###倒计时器（CountDownLatch）
> CountDownLatch是一个非常实用的多线程控制工具类。主线程在CountDownLatch上等待，当所有检查任务全部完成后，主线程方能继续执行。

###循环栅栏（CyclicBarrier）
> CyclicBarrier是另一种多线程并发控制实用工具。
    它也可以实现线程间的计数等待，功能比CountDownLatch更加复杂切强大。
    
> 计数器凑齐后，归零，重新凑齐

###线程阻塞工具类（LockSupport）
> LockSupport是一个非常方便实用的线程阻塞工具，它不需要先获得某个对象的锁，也不会抛出InterruptException。可以在任意位置让线程阻塞。
    它类似实用信号量的机制。
    
    
###线程池
 + newFixedThreadPool()方法：该方法返回一个固定线程数量的线程池。
 + newSingleThreadExecutor()方法：该方法返回一个只有一个线程的线程池。
 + newCachedThreadPool()方法：该方法返回一个可以根据实际情况调整线程数量的线程池。
 + newSingleThreadScheduledExecutor()方法：该方法返回一个ScheduledExecutorService对象，线程池大小为1。定时任务。
 + newScheduledThreadPool()方法：该方法返回一个ScheduledExecutorService对象，线程池大小可以指定。