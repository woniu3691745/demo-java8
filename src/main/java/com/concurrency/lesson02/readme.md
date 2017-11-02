##中断
> `1.public void Thread.interrupt()` // 中断线程

> `2.public boolean Thread.isInterrupted()` // 判断是否被中断

> `3.public static boolean Thread.interrupted()` // 判断是否被中断，并清除当前中断标识

##join yield
 + join() 本质是让调用线程 wait() 在当前线程对象实例上。

 + Thread.yield() 它会使当前线程让出CPU，但不代表当前线程不执行了。
 
##JMM
> java内存模型都是围绕着原子性，有序性，可见性。

##volatile 可见性
> 用volatile声明一个变量时，等于告诉虚拟机，这个变量急有可能会被某些程序或者线程修改。
> 只能确保一个线程修改了数据后，其他线程能够看到这个改动。

##守护线程（daemon）
> 在后台默默地完成一些系统性的服务，比如垃圾回收线程，JTI线程就可以理解为守护线程。
> java应用中，只有守护线程时，java虚拟机就会自然退出。

##synchronized
> 作用：实现线程的同步，对同步代码加锁，使得每一次只能有一个线程进入同步块，从而保证线程间的安全性。还可以保证线程间的可见性和有序性。

> `1.synchroized(this)` // this: 当前class的实例

> `2.synchroized(object)` // object: 当前object对象

> `3.synchroized(A.class)` // A.class: A这个类，不是对象实例

