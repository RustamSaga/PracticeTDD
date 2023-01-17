package com.rustamsaga.practicetdd

interface MyStack<T> {

    fun pop(): T
    fun push(item: T)

    class LIFO<T>(private val maxCount: Int) : MyStack<T> {

        private val array: Array<Any?>
        private var position = -1

        init {
            if (maxCount <= 0) {
                throw IllegalStateException("maxCount must be more than zero")
            }
            array = arrayOfNulls(maxCount)
        }

        override fun pop(): T {
            if (position < 0) {
                throw IllegalStateException("emptyStack")
            }

            val item = array[position] as T
            array[position] = null
            position--
            return item

        }

        override fun push(item: T) {
            position++
            try {
                array[position] = item
            }catch (e: Exception){
                throw IllegalStateException("Stack overflow exception, maximum is $maxCount")
            }
        }

    }

    class FIFO<T>(private val maxCount: Int) : MyStack<T> {

        private val array: Array<Any?> = arrayOfNulls<Any?>(maxCount)
        private var position = -1

        init {
            if (maxCount <= 0) {
                throw IllegalStateException("maxCount must be more than zero ")
            }
        }

        override fun pop(): T {
            if (position < 0) {
                throw IllegalStateException("maxCount must be more than zero")
            }
            val item = array[position] as T
            array[position] = null
            position--
            return item

        }

        override fun push(item: T) {
            position++
            try {
                array[position] = item
            } catch (e: Exception) {
                throw IllegalStateException("Stack overflow exception, maximum is $maxCount")
            }
        }

    }
}