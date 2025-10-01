package static

class Stack {

    companion object {
        val stack = mutableListOf<Int>()
        fun push (item:Int){
            stack.add(item)
        }

        fun pop():Int? {
            return if (stack.isEmpty()) null
            else stack.removeAt(stack.size-1)
        }
    }
}