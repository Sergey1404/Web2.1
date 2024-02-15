data class Node(var value: Int, var left: Node? = null, var right: Node? = null)
class BinaryTree {
    private var root: Node? = null

    fun insert(value: Int) {
        root = insertRecursive(root, value)
    }
    private fun insertRecursive(current: Node?, value: Int): Node {
        if (current == null) {
            return Node(value)
        }
        if (value < current.value) {
            current.left = insertRecursive(current.left, value)
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value)
        }
        return current
    }
    fun contains(value: Int): Boolean {
        return containsRecursive(root, value)
    }
    private fun containsRecursive(current: Node?, value: Int): Boolean {
        if (current == null) {
            return false
        }
        if (value == current.value) {
            return true
        }
        return if (value < current.value) {
            containsRecursive(current.left, value)
        } else {
            containsRecursive(current.right, value)
        }
    }
    fun remove(value: Int) {
        root = removeRecursive(root, value)
    }
    private fun removeRecursive(current: Node?, value: Int): Node? {
        if (current == null) {
            return null
        }
        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null
            }
            if (current.right == null) {
                return current.left
            }
            if (current.left == null) {
                return current.right
            }
            val smallestValue = findSmallestValue(current.right!!)
            current.value = smallestValue
            current.right = removeRecursive(current.right, smallestValue)
            return current
        }
        if (value < current.value) {
            current.left = removeRecursive(current.left, value)
        } else {
            current.right = removeRecursive(current.right, value)
        }
        return current
    }
    private fun findSmallestValue(root: Node): Int {
        return if (root.left == null) root.value else findSmallestValue(root.left!!)
    }
    fun traverseInOrder(): List<Int> {
        val result = mutableListOf<Int>()
        traverseInOrderRecursive(root, result)
        return result
    }
    private fun traverseInOrderRecursive(node: Node?, result: MutableList<Int>) {
        if (node != null) {
            traverseInOrderRecursive(node.left, result)
            result.add(node.value)
            traverseInOrderRecursive(node.right, result)
        }
    }
}
fun main() {
    val tree = BinaryTree()
    tree.insert(5)
    tree.insert(4)
    tree.insert(3)
    tree.insert(8)
    tree.insert(6)

    println(tree.contains(4))
    println(tree.contains(6))
    tree.remove(8)
    println(tree.contains(8))
    println(tree.traverseInOrder())
}
