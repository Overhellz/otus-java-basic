Примеры кода вебинара Java-Basic «Основы многопоточности. Часть 2»

1. Example1 - вызов в двух потоках у одного объекта одного синхронизированного метода
   h=ps://gist.github.com/sproshchaev/580e97a9705953e0291997400c49239f

2. Example2 - вызов в двух потоках у одного объекта разных синхронизированных методов
   h=ps://gist.github.com/sproshchaev/f8b0ce0874f94dbc7be5b15efc53bd8a

3. Example3 - вызов в двух потоках у одного объекта синхронизированного и не
   синхронизированного методов
   h=ps://gist.github.com/sproshchaev/9bf94457ea047f4c26634cac851d860b

4. Example4 - вызов одного синхронизированного статического метода в разных потоках
   h=ps://gist.github.com/sproshchaev/cf8645c982a069acb9b1625faeec336a

5. Example5 - вызов статического синхронизированного метода в разных потоках и
   синхронизированного объектного метода
   h=ps://gist.github.com/sproshchaev/044bcb43aa94c3ab3bb6e6d169e4bea6

6. Example6 - использование синхронизации с помощью мониторов для управления доступом к
   общим ресурсам
   h=ps://gist.github.com/sproshchaev/0845cddc714b144972a7eb4e39a5f91d

7. Example7 - пример взаимной блокировки (deadlock) между двумя потоками
   h=ps://gist.github.com/sproshchaev/db467e48c633fce1b811544775d9473f

8. Example8 - пример правильной остановки потока с использованием переменной-флага
   h=ps://gist.github.com/sproshchaev/39bbe7f27d421d776981dee8a7be57ec

9. Example9 - пример работы методов isShutdown() и shutdown() при использовании пула потоков
   с интерфейсом ExecutorService
   h=ps://gist.github.com/sproshchaev/322439e205a78929f9fcbfa6ac821f94

10. Example10 - пример использования пула потоков через ExecutorService для выполнения задач
    и его немедленное завершение с помощью метода .shutdownNow()
    h=ps://gist.github.com/sproshchaev/f94a82b8d5a0f0baea72d09d8ca92493

11. Example11 - пример использования Callable и возврат результата задачи через пул потоков
    ExecutorService и интерфейс Future и блокирующий метод .get()
    h=ps://gist.github.com/sproshchaev/1524db06ce8dd061cd72b35dc7a58a65

12. Example12 - пример разных видов пулов потоков: SingleThreadExecutor, FixedThreadPool,
    CachedThreadPool, ScheduledThreadPool
    h=ps://gist.github.com/sproshchaev/b5484a385b4f00f266dﬀ45d696a9cﬀ

13. Example13 - пример использования метода .awaitTerminaron() как .join() в пуле потоков
    h=ps://gist.github.com/sproshchaev/3996df0b110t01df0aef387d7d192f1

14. Example14 - слайд 13 "await()/norfy()/norfyAll()"
    h=ps://gist.github.com/sproshchaev/2c22cd84dbb2e8d99930233b94812931
