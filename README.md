# Data Structures in Java (Java 21, Maven)

This repository contains my **course notes and implementations** of core data structures in Java, along with unit tests, complexity analysis, and optional benchmarks.

It’s designed for **learning, practicing, and revising** before interviews or exams.

---

## 📚 Topics Covered

- **Arrays**
    - Static arrays
    - Dynamic arrays (resizable)
- **Linked Lists**
    - Singly linked list
    - Doubly linked list
- **Stacks & Queues**
    - Array-based stack & queue
    - Linked stack & queue
    - Circular queue
- **Hash Tables**
    - Separate chaining
    - Open addressing
- **Heaps**
    - Binary heap
    - Priority queues
- **Trees**
    - Binary search tree (BST)
    - AVL tree
    - Tries
- **Graphs**
    - Adjacency list / adjacency matrix
    - BFS / DFS
    - Shortest paths
- **Union-Find**
    - Disjoint set union (DSU)
    - Path compression + union by rank
- **Sorting**
    - Insertion, Merge, Quick, Heap sort

---

## ⚡ Complexity Reference Table

| Operation          | Array   | Dynamic Array | Linked List | Stack | Queue | Hash Table | Binary Heap | BST (avg) |
|--------------------|---------|--------------|-------------|-------|-------|------------|-------------|-----------|
| Access by index    | O(1)    | O(1)         | O(n)        | O(n)  | O(n)  | —          | O(n)        | O(log n)  |
| Insert at end      | —       | O(1)*        | O(1)        | O(1)  | O(1)  | O(1)*      | —           | O(log n)  |
| Insert at start    | —       | O(n)         | O(1)        | —     | —     | —          | —           | O(log n)  |
| Delete at end      | —       | O(1)         | O(n)        | O(1)  | —     | O(1)       | O(log n)    | O(log n)  |
| Search             | O(n)    | O(n)         | O(n)        | O(n)  | O(n)  | O(1)*      | O(n)        | O(log n)  |

`*` – amortized

---

## 📈 Big O Basic Concepts

### Common Time Complexities
- **O(1) – Constant Time**  
  Doesn't depend on the size of the data set.  
  Example: Accessing an array element by its index.

- **O(log n) – Logarithmic Time**  
  Splits the data in each step (divide and conquer).  
  Example: Binary search.

- **O(n) – Linear Time**  
  Directly proportional to the data set size.  
  Example: Looping through an array.

- **O(n log n) – Linearithmic Time**  
  Splits and sorts/searches data.  
  Example: Merge sort, quick sort.

- **O(n²) – Polynomial Time**  
  Nested loops for each power of n.  
  Example: Bubble sort (O(n²)).

---

### Best, Average, and Worst Case
- **Omega (Ω) – Best Case**  
  Describes the *fastest* an algorithm can run in the best circumstances.

- **Theta (Θ) – Average Case**  
  Describes the expected time complexity in general situations.

- **Big O (O) – Worst Case**  
  Describes the *slowest* an algorithm can run in the worst circumstances.

---

### Useful Tips
- **Drop Non-Dominant Terms**  
  In `O(n² + n)`, focus on `O(n²)` as it dominates for large `n`.

- **Drop Constants**  
  `O(2n)` simplifies to `O(n)`.

---

## 🛠 Project Setup

### Requirements
- Java 21+
- Maven 3.9+
- Any IDE (IntelliJ IDEA recommended)

### Run Tests
```bash
  mvn test
