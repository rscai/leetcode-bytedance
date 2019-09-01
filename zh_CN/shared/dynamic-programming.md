>### 动态规划
>
>动态规划（英语：Dynamic programming，简称DP）是一种在数学、管理科学、电脑科学、经济学和生物资讯学中使用的，通过把原问题分解为相对简单的子问题的方式求解复杂问题的方法。
>
>动态规划常常适用于有重叠子问题和最佳子结构性质的问题，动态规划方法所耗时间往往远少于朴素解法。
>
>动态规划背后的基本思想非常简单。大致上，若要解一个给定问题，我们需要解其不同部分（即子问题），再根据子问题的解以得出原问题的解。
>
>通常许多子问题非常相似，为此动态规划法试图仅仅解决每个子问题一次，从而减少计算量：一旦某个给定子问题的解已经算出，则将其记忆化储存，以便下次需要同一个子问题解之时直接查表。这种做法在重复子问题的数目关于输入的规模呈指数增长时特别有用。
>
>#### 概述
>
>动态规划在寻找有很多重叠子问题的情况的最佳解时有效。它将问题重新组合成子问题。为了避免多次解决这些子问题，它们的结果都逐渐被计算并被储存，从简单的问题直到整个问题都被解决。因此，动态规划储存递回时的结果，因而不会在解决同样的问题时花费时间。
>
>动态规划只能应用于有最佳子结构的问题。最佳子结构的意思是局部最佳解能决定全域最佳解（对有些问题这个要求并不能完全满足，故有时需要引入一定的近似）。简单地说，问题能够分解成子问题来解决。
>
>#### 适用情况
>
>1. 最佳子结构性质。如果问题的最佳解所包含的子问题的解也是最佳的，我们就称该问题具有最佳子结构性质（即满足最佳化原理）。最佳子结构性质为动态规划演算法解决问题提供了重要线索。
>2. 无后效性。即子问题的解一旦确定，就不再改变，不受在这之后、包含它的更大的问题的求解决策影响。
>3. 子问题重叠性质。子问题重叠性质是指在用递回演算法自顶向下对问题进行求解时，每次产生的子问题并不总是新问题，有些子问题会被重复计算多次。动态规划演算法正是利用了这种子问题的重叠性质，对每一个子问题只计算一次，然后将其计算结果储存在一个表格中，当再次需要计算已经计算过的子问题时，只是在表格中简单地检视一下结果，从而获得较高的效率。
>
>#### 参考
>
>* [动态规划](https://zh.wikipedia.org/wiki/动态规划)
>* [Dynamic Programming](https://en.wikipedia.org/wiki/Dynamic_programming)