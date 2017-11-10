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
 
###核心线程池的内部实现
    'public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler)'
  + corePoolSize: 指定了线程池中的线程数量。
  + maximumPoolSize：指定了线程池中的最大线程数量。
  + keepAliveTime：当线程池线程数量超过corePoolSize时，多余的空闲线程的存活时间。
    即，超过corePoolSize的空闲线程，在多长时间内，会被销毁。
  + unit：keepAliveTime的单位。
  + workQueue：任务队列，被提交但尚未被执行的任务。
  + ThreadFactory：线程工厂，用于创建线程，一般用默认的即可。
  + handler：拒绝策略。当任务太多来不及处理，如何拒绝任务。
  
> workQueue

+ 直接提交的队列
+ 有界的任务队列
+ 无界的任务队列
+ 优先任务队列

###超负载了怎么办？拒绝策略
  + AbortPolicy策略：该策略会直接抛出异常，阻止系统正常工作。
  + CallerRunsPolicy策略：只要线程池未关闭，该策略直接在调用者线程中，运行当前被丢弃的任务。
  + DiscardOledestPolicy策略：该策略将丢弃最老的一个请求，也就是即将被执行的一个任务，并尝试再次提交当前任务。
  + DiscardPolicy策略：该策略默默地丢弃无法处理的任务，不予任何处理。

###分而治之（Fork/Join）
> ForkJoinTask任务就是支持fork()分解及join()等待的任务。
  + RecursiveAction：没有返回值的任务。
  + RecursiveTask：可以携带返回值的任务。
  
  
###超好用的工具类：并发集合简介
+ ConcurrentHashMap：这是一个高效的并发HashMap，这是一个线程安全的HashMap。
+ CopyOnWriteArrayList：这是一个List，从名字看就是和ArrayList是一族的，在读写少的场合，这List的性能非常好，远远好于Vector。
+ ConcurrentLinkedQueue：高效的并发队列，使用链表实现。可以看做一个线程安全的LinkedList。
+ BlockingQueue：这是一个接口，JDK内部通过链表，数组等方式实现了这个接口。表示阻塞队列，非常适合用于作为数据共享的通道。
+ ConcurrentSkipListMap：跳表的实现。这是一个Map，使用跳表的数据结构进行快速查找。（有序Map）