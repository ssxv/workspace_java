# data_structures
- [Linear Data Structure](#linearDataStructure)
    - [Linked List](#linkedList)
        - [Singly Linked List](#singlyLinkedList)
        - [Doubly Linked List](#doublyLinkedList)
- [Non Linear Data Structure](#nonLinearDataStructure)
    - [Trees](#trees)
        - [Binary Tree](#binaryTree)
        - [Binary Search Tree](#binarySearchTree)
        - [Binary Heap](#binaryHeap)

# Linear Data Structure
## Linked List
Like arrays, Linked List is a linear data structure. Unlike arrays, linked list elements are not stored at contiguous location; the elements are linked using pointers.

**Why Linked List?**

Arrays can be used to store linear data of similar types, but arrays have following limitations.
* The size of the arrays is fixed: So we must know the upper limit on the number of elements in advance. Also, generally, the allocated memory is equal to the upper limit irrespective of the usage.
* Inserting a new element in an array of elements is expensive, because room has to be created for the new elements and to create room existing elements have to shifted.

**Advantages over arrays**
* Dynamic size
* Ease of insertion/deletion

**Drawbacks**
* Random access is not allowed. We have to access elements sequentially starting from the first node. So we cannot do binary search with linked lists.
* Extra memory space for a pointer is required with each element of the list.

### Singly Linked List
LinkedList can be represented as a class and a Node as a separate class. The LinkedList class contains a reference of Node class type.

In Singly Linked List, there is only one **Node** reference.
```
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
```
### Doubly Linked List
In Doubly Linked List, there are two **Node** references.
```
class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
```

# Non Linear Data Structure

## Trees
Unlike Arrays, Linked Lists, Stack and queues, which are linear data structures, trees are hierarchical data structures.

**Why Trees ?**
* One reason to use trees might be because you want to store information that naturally forms a hierarchy. For example, the file system on a computer:
```
file system
-----------
            /    <-- root
        /      \
       ...       home
       /           \
   ugrad        course
    /         /    |     \
  ...      cs101  cs112  cs113
```
* Trees (with some ordering e.g., BST) provide moderate access/search (quicker than Linked List and slower than arrays).
* Trees provide moderate insertion/deletion (quicker than Arrays and slower than Unordered Linked Lists).
* Like Linked Lists and unlike Arrays, Trees don’t have an upper limit on number of nodes as nodes are linked using pointers.

**Main applications of trees include:**
* Manipulate hierarchical data.
* Make information easy to search (see tree traversal).
* Manipulate sorted lists of data.
* As a workflow for compositing digital images for visual effects.
* Router algorithms.
* Form of a multi-stage decision-making (see business chess).

### Binary Tree
A tree whose elements have at most 2 children is called a binary tree. Since each element in a binary tree can have only 2 children, we typically name them the left and right child.

### Binary Search Tree
Binary Search Tree, is a node-based binary tree data structure which has the following properties:
    * The left subtree of a node contains only nodes with keys less than the node’s key.
    * The right subtree of a node contains only nodes with keys greater than the node’s key.
    * The left and right subtree each must also be a binary search tree.
    * There must be no duplicate nodes.

### Binary Heap
A Binary Heap is a Binary Tree with following properties.
    * It’s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible). This property of Binary Heap makes them suitable to be stored in an array.
    * A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap. The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to Min Heap.

**Examples of Min Heap:**
```
            10                      10
         /      \               /       \
       20        100          15         30
      /                      /  \        /  \
    30                     40    50    100   40
```

**How is Binary Heap represented?**

A Binary Heap is a Complete Binary Tree. A binary heap is typically represented as array. Please refer below article for details.
Array Representation Of Binary Heap

**Applications of Heaps:**
* Heap Sort: Heap Sort uses Binary Heap to sort an array in O(nLogn) time.
* Priority Queue: Priority queues can be efficiently implemented using Binary Heap because it supports insert(), delete() and extractmax(), decreaseKey() operations in O(logn) time. Binomoial Heap and Fibonacci Heap are variations of Binary Heap. These variations perform union also efficiently.
* Graph Algorithms: The priority queues are especially used in Graph Algorithms like Dijkstra’s Shortest Path and Prim’s Minimum Spanning Tree.
* Many problems can be efficiently solved using Heaps. See following for example.
    * K’th Largest Element in an array.
    * Sort an almost sorted array/
    * Merge K Sorted Arrays.

**Operations on Min Heap:**
* getMini(): It returns the root element of Min Heap. Time Complexity of this operation is O(1).
* extractMin(): Removes the minimum element from Min Heap. Time Complexity of this Operation is O(Logn) as this operation needs to maintain the heap property (by calling heapify()) after removing root.
* decreaseKey(): Decreases value of key. Time complexity of this operation is O(Logn). If the decreases key value of a node is greater than parent of the node, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.
* insert(): Inserting a new key takes O(Logn) time. We add a new key at the end of the tree. IF new key is greater than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.
* delete(): Deleting a key also takes O(Logn) time. We replace the key to be deleted with minum infinite by calling decreaseKey(). After decreaseKey(), the minus infinite value must reach root, so we call extractMin() to remove key.