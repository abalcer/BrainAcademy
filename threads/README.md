# Примеры создания потоков и методы синхронизации

## ApplicationDemo class
> Класс демонстрирует как можно "распараллелить" выполнение задачи с использованием потоков.

## VolatileTest class
> Класс демонстрирует работу потоков с **volatile** переменными.

После запуска, получим следующие результаты:

* С использованием ключевого слова **volatile**:
```
    Incrementing MY_INT to 1
    Got Change for MY_INT : 1
    Incrementing MY_INT to 2
    Got Change for MY_INT : 2
    Incrementing MY_INT to 3
    Got Change for MY_INT : 3
    Incrementing MY_INT to 4
    Got Change for MY_INT : 4
    Incrementing MY_INT to 5
    Got Change for MY_INT : 5
 ```

* Без использования ключевого слова **volatile**:

```
    Incrementing MY_INT to 1
    Incrementing MY_INT to 2
    Incrementing MY_INT to 3
    Incrementing MY_INT to 4
    Incrementing MY_INT to 5
```

Каждый поток имеет свой собственный стек, и соотвественно, свои копии переменных, с которыми он работает.
Когда поток создается, он копирует значение всех доступных переменных в свою собственную память.
Ключевое слово **volatile** используется, чтобы сказать Jvm "Внимание, эта переменная может быть изменена в другом потоке".
Без этого ключевого слова виртуальная машина может выполнить некоторую оптимизацию, и никогда не обновлять локальные копии в потоках.
Ключевое слово **volatile** заставляет поток обновить исходную перемнную для каждой переменной.

## SynchronizedTest class
> Класс демонстрирует синхронизацию потоков с использованием **synсhronized** блоков

При запуске потоков без синхронизации, получим вывод:
```
NonSync2: 2
NonSync2: 3
NonSync2: 4
NonSync2: 5
NonSync1: 1
NonSync1: 1
NonSync1: 2
NonSync1: 3
NonSync1: 4
NonSync1: 5
```
При запуске потоков с синхронизацией:
```
Sync1: 1
Sync1: 2
Sync1: 3
Sync1: 4
Sync1: 5
Sync2: 1
Sync2: 2
Sync2: 3
Sync2: 4
Sync2: 5
```

В первом случае каждый поток получает доступ к глобальной переменной **val** в произвольный момент времени.
Во втором - после захода в **synchronized** блок, второй поток не получит доступа к переменной, пока первый не выйдет из блока **synchronized**.

