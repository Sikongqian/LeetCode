# 栈与队列
栈：先进先出 FIFO

队列：后进先出 LIFO

## java

栈（Stack） 这个类继承自 Vector ，底层用数组实现，是 JDK1.0 时代的产物，官方已经不推荐使用了。

队列（Queue） 的话，JDK1.6 开始声明了 Deque（double ended queue ）双向队列接口 ，双向队列同时具备栈和队列的功能。

所以现在选择在 java 中使用 栈和队列 的话，推荐选择实现了 Deque 的

  首选是 ArrayDeque ，其次是 LinkedList ，当然这两个都不是线程安全的。

  对于线程安全的需求，JDK 提供了 BlockingQueue 阻塞队列以及双向队列，这也是一个非常重要的接口。（本文不介绍，重新开一篇。）
 
https://blog.csdn.net/m0_46144826/article/details/105405172
