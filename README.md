## LeetCode刷题笔记

### Day1

##### 1. 两数之和

**知识点**：哈希表，键为元素值，值为索引。边遍历边判断差值是否存在于哈希表

---

##### 2. 两数相加

**知识点**：链表遍历

---

##### 53. 最大子序和

**知识点**：动态规划或者贪心算法

----

##### 983. 最低票价

**知识点**：动态规划

---

### Day30

##### 33. 搜索旋转排序数组。

**知识点**：变异的二分查找

---

##### 127. 单词接龙

**知识点**：BFS

---

##### 126. 单词接龙 II

**知识点**：BFS，不会

---

### Day31

##### 34. 在排序数组中查找元素的第一个和最后一个位置

**知识点**：二分查找，查找给定target在排序数组中出现的左右边界

---

##### 990. 等式方程的可满足性

**知识点**：并查集、包含小写字母的字符串的处理

---

### Day32

##### 面试题46. 把数字翻译成字符串

**知识点**：动态规划，一维动态规划，dp[i]代表以i结束时有效字符串的个数

---

##### 36. 有效的数独 

**知识点**：遍历一遍数组，怎么想的怎么实现就欧克

---

### Day33

##### 9. 回文数

**知识点**：简单双指针、整数反转

---

##### 37. 解数独

**知识点**：DFS和回溯算法，与N皇后的回溯解法有相似之处

---

### Day34

##### 15. 三数之和

**知识点**：排序，双指针。易错点在于去重

----

##### 739. 每日温度 

**知识点**：最小栈。或者从后往前遍历，如果T[j]<=T[i]，j此时可以直接等于j+=ans[j]

---

### Day35

##### 70. 爬楼梯

**知识点**：动态规划，很简单的递推公式

---

### Day36

##### 1300. 转变数组后最接近目标值的数组和

**知识点**：搜索，但又不是二分查找，关键是从target/arr.length开始向上递增判断那个i最接近答案

---

### Day37

##### 14. 最长公共前缀

**知识点**：字符数组、字符串处理

---

##### 35. 搜索插入位置

**知识点**：标准二分查找

---

### Day38

---

##### 297. 二叉树的序列化与反序列化

**知识点**：二叉树的非递归遍历和根据先序遍历创建二叉树（利用队列或数组）

---

##### 1014. 最佳观光组合

**知识点**：类似动态规划，A[i] + i + A[j]- j，j>i

---

##### 125. 验证回文串

**知识点**：简单的双指针应用

---

##### 1028. 从先序遍历还原二叉树

**知识点**：不是常规的先序序列，节点值的前面给出了该节点的深度。因此子节点的深度一定大于父节点，记录每个节点的深度值，判断其是否大于父节点的深度以此来递归构建树。递归、构建树

---

### Day39

---

##### 112. 路径总和

**知识点**：二叉树的节点遍历；递归。从根节点开始往每个叶子节点递归，每次将sum的值更新为sum-node.val(node为当前节点的值)。递归的退出条件是当前节点的左右节点都为null，此时如果sum的值不为0则返回false,否在返回true

---

##### 面试题 16.18. 模式匹配

**知识点**：字符串匹配，枚举

---

### Day40

##### 题号：67. 二进制求和

**知识点**：字符串遍历，类似于第2题

---

##### 题号：104. 二叉树的最大深度

**知识点**：二叉树递归

---

##### 题号：105. 从前序与中序遍历序列构造二叉树

**知识点**：二叉树构造

---

### Day41

##### 题号：16. 最接近的三数之和

**知识点**：排序，双指针，与15题有细微差别

---

##### 题号：39. 组合总和

**知识点**：DFS+回溯剪枝，重难点在于剪枝去除重复的元素

---

### Day42

##### 题号：139. 单词拆分

**知识点**：DFS+回溯；一维动态规划，dp[i]代表s.substring(0,i)是否可以被拆分为wordDict中的元素

---

##### 题号：面试题 02.01. 移除重复节点

**知识点**：快慢指针，配合一个集合来保存已经读取过的值

---

### Day43

##### 题号：41. 缺失的第一个正数

**知识点**：原地置换，思路类似于剑指Offer面试题3

---

##### 题号：287. 寻找重复数

**知识点**：二分查找延拓

---

##### 题号：268. 缺失数字

**知识点**：原地置换；位运算

---

### Day44

##### 题号：209. 长度最小的子数组

**知识点**：简单的滑动窗口问题

---

##### 题号：54. 螺旋矩阵

**知识点**：二维数组顺时针模拟输出

---

##### 题号：240. 搜索二维矩阵 II

**知识点**：“有序”二维矩阵搜索

---

### Day45

##### 题号：215. 数组中的第K个最大元素

**知识点**：快速排序思想

---

### Day46

##### 题号：剑指 Offer 09. 用两个栈实现队列

**知识点**：栈、队列

---

##### 题号：700. 二叉搜索树中的搜索

**知识点**：二叉搜索树、递归

---

##### 题号：701. 二叉搜索树中的插入操作

**知识点**：二叉搜索树、递归（将待插入元素都插在叶子节点）

---

##### 题号：堆排序

**知识点**：创建堆、排序

---

### Day47

##### 题号：718. 最长重复子数组

**知识点**：二维动态规划、类似于最长公共子串

---

##### 题号：225. 用队列实现栈

**知识点**：队列、栈。镜像问题：用队列实现栈

---

### Day48

##### 题号：378. 有序矩阵中第K小的元素

**知识点**：矩阵的二分查找

---

##### 题号：108. 将有序数组转换为二叉搜索树

**知识点**：二叉搜索树、递归建树

---

##### 题号：509. 斐波那契数

**知识点**：动态规划或递归

---

### Day49

##### 题号：33. 搜索旋转排序数组(数组中没有重复元素)

**知识点**：二分查找、旋转有序数组

---

##### 题号：81. 搜索旋转排序数组 II（数组中有重复元素）

**知识点**：二分查找、旋转有序数组

---

##### 题号：153. 寻找旋转排序数组中的最小值(数组中没有重复元素)

**知识点**：二分查找、旋转有序数组

---

##### 题号：154. 寻找旋转排序数组中的最小值 II（数组中有重复元素）

**知识点**：二分查找、旋转有序数组

---

### Day50

##### 题号：32. 最长有效括号

**知识点**：一维动态规划。关键点是dp[i]的含义，dp[i]代表若i位是')'，dp[i]代表以该')‘结尾的最长括号。如果第i位是'('，那么dp[i]为0

---

##### 题号：79. 单词搜索

**知识点**：常规（深度优先搜索）dfs+回溯算法

---

### Day51

##### 题号：44. 通配符匹配

**知识点**：涉及两个字符串的二维动态规划

---

##### 题号：343. 整数拆分(剑指Offer 14题)

**知识点**：一维动态规划

---

##### 题号：191. 位1的个数

**知识点**：位运算

---

### Day52

##### 题号：63. 不同路径 II

**知识点**：简单的动态规划问题

---

##### 题号：62. 不同路径 

**知识点**：简单的动态规划问题

---

### Day53

##### 题号：112. 路径总和

**知识点**：二叉树的常规递归问题。如果node节点的左右子树为空，且sum=node.val则返回true，否在返回false。如果node不是叶子节点，则继续递归，同时令sum=sum-node.val

---

##### 题号：50. Pow(x, n)

**知识点**：数学。pow(x,10)=pow(x,5)*pow(x,5);pow(x,5)=pow(x,2)*pow(x,2)*x

---

### Day54

##### 题号：面试题 16.11. 跳水板

**知识点**：数学思路

---

### Day55

##### 题号：139. 单词拆分

**知识点**：动态规划。dp[i]代表s的[0,i)个字符组成的子串能否被拆分成词典中的单词， 例如dp[5]代表s.substring(0,5)这个子串能被拆分成字典中的单词

---

##### 题号：面试题 17.13. 恢复空格

**知识点**：动态规划。dp[i]代表前i个字符中有多少个未匹配的字符

---

### Day56

##### 题号：121. 买卖股票的最佳时机

**知识点**：峰谷法或者迭代

---

##### 题号：122. 买卖股票的最佳时机 II

**知识点**：峰谷法或动态规划。二维动态规划dp[i] [0]代表第i天持有股票时的最大收益；dp[i] [1]代表第i天不持有股票，能买入股票的最大收益

---

##### 题号：309. 最佳买卖股票时机含冷冻期

**知识点**：动态规划。dp[i] [0]代表第i天持有股票时的收益;dp[i] [1]代表第i天不持有股票但是也不能买入（说明股票第i-1天卖出了）的收益;dp[i] [2]代表第i天不持有股票同时能买入的收益

---

### Day57

##### 题号：174. 地下城游戏

**知识点**：动态规划问题。二维的动态规划，不同于以往的二维dp从左上角开始，这次是从右下角dp到左上角

---

##### 题号：83. 删除排序链表中的重复元素

**知识点**：链表。思路与删除链表指定节点不同，如果cur.val=cur.next.val，此时cur.next=cur.next.next；否在cur=cur.next

---

##### 题号：27. 移除元素

**知识点**：双指针、快慢指针问题。与26题的思路几乎一样

---

### Day58

##### 题号：350. 两个数组的交集 II

**知识点**：哈希表、数组

---

##### 题号：120. 三角形最小路径和

**知识点**：从低向上的二维动态规划、动态规划的空间优化

---

### Day59

##### 题号：96. 不同的二叉搜索树

**知识点**：二叉树，二叉搜索树。长度为i，以j为根节点，左子树的数量为j-1；右子树为i-j

---

##### 题号：785. 判断二分图

**知识点**：广度优先搜索（BFS）。相邻的节点一定是属于不同的子集

---

##### 题号：35. 搜索插入位置

**知识点**：标准二分查找。在二分查找中low的范围是[0,len]，high的范围是[-1,len-1]

---

### Day60

##### 题号：97. 交错字符串

**知识点**：DFS加回溯、记忆化搜索。使用dfs枚举所有的可能性，但是需要使用记忆化否在会超时

---

##### 题号：312. 戳气球

**知识点**：动态规划、递归。每次从(i, j)区间内选择一个气球k放置在一个新的区间(i, j)，这个区间除了i和j位置外其他地方都是空的，此时得到的coins为a[i] * a[k] * a[j]，放置气球k之后，我们现在得到两个左右区间(i, k)和(k, j)，计算这两个区间的最大coins数也是一样的，因此，递归计算两个区间的最大coins数

---

### Day61

##### 题号：167. 两数之和 II - 输入有序数组

**知识点**：哈希表、双指针

---

##### 题号：96. 不同的二叉搜索树

**知识点**：二刷，动态规划

---

##### 题号：95. 不同的二叉搜索树 II

**知识点**：递归，利用到了96的思路。递归得到左右子树集，最后将左右子树组合就得到整个不同的二叉搜索树集合

---

### Day62

##### 题号：154. 寻找旋转排序数组中的最小值 II

**知识点**：2刷。二分思想，充分利用旋转数组的特点，特别注意去重

---

##### 题号：65. 有效数字

**知识点**：有限状态机

> ```
> 直接遍历判断的，需要注意的有以下几点
> 1、如果字符是正负号则必须位于第1位或者是e之后的第一位，且正负号不能是最后一位
> 2、如果字符是点'.'，则在点的左右两边必须有一边有数字（.9这种也是对的，没想到），且只能出现一次小数点
> 3、如果字符是e，则在e出现之前必须有数字出现，且e不能是最后一位
> 4、字符e之后不能出现任何小数点和再次出现e
> ```

---

### Day63

##### 题号：64. 最小路径和

**知识点**：常规动态规划

---

##### 题号：1025. 除数博弈

**知识点**：找规律、动态规划

---

##### 题号：39. 组合总和

**知识点**：2刷，dfs+回溯

---

##### 题号：40. 组合总和 II

**知识点**：类似39题，dfs+回溯+去重

---

### Day64

##### 题号：392. 判断子序列

**知识点**：简单双指针应用

---

##### 题号：104. 二叉树的最大深度

**知识点**：DFS或者BFS类似于层次遍历

---

##### 题号：410. 分割数组的最大值

**知识点**：动态规划，dp[i] [j]表示前i个数被分成j组后的最大的最小值；二分查找，下线是数组中的最大值，上限是整个数组的和

---

##### 题号：329. 矩阵中的最长递增路径

**知识点**：dfs+记忆化，比较巧妙

### Day65

##### 题号：343. 整数拆分

**知识点**：比较简单的前向动态规划；剑指offer原题

---

##### 题号：142. 环形链表 II

**知识点**：双指针，首先求出环的长度n，再然一个指针前进n步，另一个指针从头节点开始。两个指针每次前进一步，当相遇时的节点就是入口；哈希表

### Day66

##### 题号：632. 最小区间

**知识点**：堆应用中比较典型的题，很巧妙的思路

---

##### 题号：114. 二叉树展开为链表

**知识点**：二叉树遍历、递归

---

### Day67

##### 题号：415. 字符串相加

**知识点**：常规题，处理好进位即可

---

##### 题号：207. 课程表

**知识点**：常规拓扑排序。BFS或DFS

---

##### 题号：337. 打家劫舍 III

**知识点**：DFS+记忆化，对于每一个节点，如果偷了当前节点，那么就只能偷其孙子节点；如果不偷当前节点，那么可以偷其儿子节点。这样比较这二者取最大值即可；DP，对于每个节点，有偷或不偷两种情况，如果偷了当前节点，那么最大值就是不偷其左右孩子能获得的最大值加当前节点的值的和；如果不偷当前节点，那么最大值就是其左右孩子能获得的最大值之和。因此对于每个节点定义两个状态0表示不偷，1表示偷

---

### Day68

##### 题号：100. 相同的树

**知识点**：二叉树。简单递归

---

##### 题号：42. 接雨水

**知识点**：双指针、按列计算

---

##### 题号：99. 恢复二叉搜索树

**知识点**：二叉搜索树，先找到逆序的两个节点，再交换即可

---

##### 题号：98. 验证二叉搜索树

**知识点**：二叉搜索树。遍历完之后看有没有逆序的，或者使用非递归遍历，边遍历边判断当前节点的值是不是大于前一个节点的值；递归

---

### Day69

##### 题号：93. 复原IP地址

**知识点**：暴力，循环三个插入点；DFS，dfs(s,start,index)。start代表第index个片段的起始位置，index代表第几个片段

---

##### 题号：696. 计数二进制子串

**知识点**：中心扩展

---

##### 题号：130. 被围绕的区域

**知识点**：DFS或BFS

---

### Day70

##### 题号：133. 克隆图

**知识点**：BFS，巧妙的利用了一个哈希表，哈希表的键是原来的节点，值是克隆的节点

---

##### 题号：43. 字符串相乘

**知识点**：模拟自己手动写乘法的过程。将一个数的每一位与另外的一个数相乘后相加，不过需要记得补0

---

##### 题号：20. 有效的括号

**知识点**：栈的简单应用

---

### Day71

##### 题号：P1003 铺地毯

**知识点**：不要直接使用二维数组，因为不知道铺设的地毯范围；使用一个地毯类存储每个地毯的坐标信息，将每个地毯存到一维数组中，最后倒序遍历地毯，看输入的坐标是否再范围内，如果是输出即可，遍历结束都没有找到即输出-1

---

##### 题号：P1004 方格取数

**知识点**：神一样的四维DP。可以理解为两个人同时从左上角开始走，dp(i)(j)(k)(l)，代表第一个人到达i,j位置，第二个人到达k,l位置时能取到的最大值。我们的目的
是求dp(n)(n)(n)(n)，即两个人都到达n,n位置时的最大值。可以从(i-1)(j)和(i)(j-1)两个位置到达(i)(j)；可以从(k-1)(l)、(k)(l-1)两个位置到达 (k)(l)

---

##### 题号：55. 跳跃游戏

**知识点**：贪心算法

---

##### 题号：946. 验证栈序列

**知识点**：栈的应用。用popArr数组结合栈模拟过程。遍历popArr的元素，如果其等于栈顶元素，则弹出栈顶元素，继续遍历；如果不等于栈顶元素，则对pushArr数组元素进行入栈，直到遍历到pushArr元素等于popArr元素。如果遍历pushArr到最后都没有元素等于popArr的元素，则返回false

---

##### 题号：733. 图像渲染

**知识点**：BFS和DFS简单应用

---

### Day72

##### 题号：110. 平衡二叉树

**知识点**：涉及求二叉树高度，以及二叉树递归的常用模板

---

##### 题号：109. 有序链表转换二叉搜索树

**知识点**：递归建树、快慢指针寻找链表的中间节点

---

##### 题号：P1048 采药

**知识点**：背包问题

---

##### 题号：P1616 疯狂的采药

**知识点**：完全背包问题，，，时间和空间优化

---

##### 题号：377. 组合总和 Ⅳ

**知识点**：动态规划。跑楼梯问题泛化

---

### Day73

##### 题号：647. 回文子串

**知识点**：回文串常用的动态规划。dp(i)(j)为true的条件是dp(i+1)(j-1)为true，且i位置的元素等于j位置的元素

---

##### 题号：416. 分割等和子集

**知识点**：动态规划，口袋问题

---

##### 题号：529. 扫雷游戏

**知识点**：DFS或BFS

---

##### 题号：111. 二叉树的最小深度

**知识点**：1、凡是这种求深度的问题都可以用层次遍历BFS的思路求解；2、DFS

---

### Day74

##### 题号：201. 数字范围按位与

**知识点**：位运算，可以用暴力的方式解决。比较直观易理解的方法是找到m和n的公共前缀，公共前缀其实就是它们之间所有数字按位与的结果。

---

##### 题号：459. 重复的子字符串

**知识点**：暴力或者使用KMP算法

---

##### 题号：491. 递增子序列

**知识点**：dfs。用HashSet来对结果进行去重

---

### Day75

##### 题号：17. 电话号码的字母组合

**知识点**：DFS

---

##### 题号：45. 跳跃游戏 II

**知识点**：贪心算法。因为保证了一定可以跳跃到最后的位置，因此只需要找出每次跳跃范围内，下次可以跳跃的最远距离即可

---

##### 题号：332. 重新安排行程

**知识点**：别样的DFS。涉及列表边遍历边删除和逆序插入问题

---

##### 题号：657. 机器人能否返回原点

**知识点**：简单题

---

### Day76

##### 题号：214. 最短回文串

**知识点**：KMP算法应用，KMP变形

---

##### 题号：557. 反转字符串中的单词 III

**知识点**：双指针，找到每个单词并依次反转即可

---

##### 题号：841. 钥匙和房间

**知识点**：常规DFS/BFS

---

##### 题号：486. 预测赢家

**知识点**：别样的动态规划或递归

---

### Day77

##### 题号：剑指 Offer 20. 表示数值的字符串

**知识点**：状态机。有题解

---

##### 题号：51. N 皇后

**知识点**：经典dfs

---

##### 题号：48. 旋转图像

**知识点**：先将矩阵元素按主对角交换，然后左右对称即可

---

##### 题号：257. 二叉树的所有路径

**知识点**：二叉树的遍历问题，不过要用到回溯算法

---

### Day78

##### 题号：49. 字母异位词分组

**知识点**：排序，哈希

---

##### 题号：53. 最大子序和

**知识点**：动态规划或者直接前缀和处理

---

##### 题号：60. 第k个排列

**知识点**：DSF+回溯

---

##### 题号：76. 最小覆盖子串

**知识点**：滑动窗口

---

### Day79

##### 题号：347. 前 K 个高频元素

**知识点**：比较器排序，哈希

---

##### 题号：55. 跳跃游戏

**知识点**：贪心

---

##### 题号：45. 跳跃游戏 II

**知识点**：经典贪心问题

---

##### 题号：77. 组合

**知识点**：dfs+回溯

---

### Day80

##### 题号：56. 合并区间

**知识点**：对二维数组按第一个元素进行排序，排序之后比较第i个一维数组的第二个元素是否大于第i+1个一维数组的第一个元素(arr[i][1]>=arr[i+1][0])，如果满足
条件说明这两个区间可以合并，合并后的新区间的左边界为arr[i][0]，右区间为max(arr[i][1],arr[i+1][1])

---

##### 题号：39. 组合总和

**知识点**：比较典型的回溯+去重

---

##### 题号：40. 组合总和 II

**知识点**：DFS+回溯+剪枝

---

##### 题号：216. 组合总和 III

**知识点**：比较典型的回溯+去重。和组合总数1类似

---

### Day81

##### 题号：57. 插入区间

**知识点**：先将新插入的区间插入到有序的已有区间中，然后再合并区间即可

---

##### 题号：59. 螺旋矩阵 II

**知识点**：和螺旋矩阵Ⅰ思路一模一样

---

##### 题号：637. 二叉树的层平均值

**知识点**：二叉树层级遍历

---

### Day82

##### 题号：79. 单词搜索

**知识点**：DFS+回溯

---

##### 题号：94. 二叉树的中序遍历

**知识点**：二叉树遍历

---

##### 题号：226. 翻转二叉树

**知识点：先序遍历，遍历到最后交换左右节点**

---

##### 题号：47. 全排列 II

**知识点**：回溯去重，考虑set集合去重，和技巧性去重

---

##### 题号：404. 左叶子之和

**知识点**：使用标志位判断是否为左子树；或者使用一个全局preNode，记录前一个遍历的节点，然后使用先序遍历，如果前一个节点是当前节点的左孩子且左右节点为0，即相加

---

##### 题号：845. 数组中的最长山脉

**知识点**：动态规划

---

##### 题号：78. 子集

**知识点**：dfs。有点类似组合总数，不过子集的长度是1到n，一个循环即可

---

##### 题号：538. 把二叉搜索树转换为累加树

**知识点**：利用二叉搜索树的性质，右节点-根-左节点。根=根+右节点；左节点=左节点+根

---

##### 题号：617. 合并二叉树

**知识点**：较常规的二叉树题目，二叉树遍历

---

##### 题号：501. 二叉搜索树中的众数

**知识点**：二叉搜索树遍历，需要记录前一个节点

---

##### 题号：113. 路径总和 II

**知识点**：比较典型的二叉树深搜+回溯问题

---

### Day83

##### 题号：235. 二叉搜索树的最近公共祖先

**知识点**：利用二叉搜索树的性质。不需要递归，仅简单迭代即可

---

##### 题号：297. 二叉树的序列化与反序列化

**知识点**：大话数据结构中利用扩展二叉树建树

---

##### 题号：117. 填充每个节点的下一个右侧节点指针 II

**知识点**：

1、使用层次遍历，但是会使用到一个队列O，空间复杂度为O(n)
2、利用链表的思想实现，空间复杂度降为O(1)

---

##### 题号：145. 二叉树的后序遍历

**知识点**：关键是掌握非递归的方法

---

##### 题号：701. 二叉搜索树中的插入操作

**知识点**：只要知道，利用二叉搜索树的性质每次将新节点插入二叉到二叉搜索树的叶子节点即可

---

### Day84

##### 题号：771. 宝石与石头

**知识点**：字符串简单遍历

---

##### 题号：1. 两数之和

**知识点**：哈希表

---

##### 题号：2. 两数相加

**知识点**：链表遍历

---

##### 题号：LCP 19. 秋叶收藏集

**知识点**：动态规划。f(i)(j)，其中j的取值只能为0，1，2.分别代表前面的红色，中间的黄色和后面的红色。i代表，前面[0~i-1)位置上的颜色都调整好了，且满足要求时的最小调整步骤；此时要调整第i个位置上的颜色。

---

### Day85

##### 题号：18. 四数之和

**知识点**：魔改三数之和。相似题目：三数之和

---

##### 题号：75. 颜色分类

**知识点**：排序算法；双指针，重点掌握这里双指针的巧妙使用

---

##### 题号：141. 环形链表

**知识点**：链表快慢指针的使用

---

### Day86

##### 题号：142. 环形链表 II

**知识点**：链表典型问题

---

##### 题号：416. 分割等和子集

**知识点**：动态规划。背包问题（口袋问题）

---

##### 题号：530. 二叉搜索树的最小绝对差

**知识点**：中序遍历结合一个指向当前节点的前一个节点的指针

---

##### 题号：25. K 个一组翻转链表

**知识点**：提取出k个节点作为一个单独的链表（需要记录下截取链表的首尾节点），并反转

---

### Day87

##### 题号：1002. 查找常用字符

**知识点**：找出每个字符串中字母出现的频数构成一个26的（只有小写字母）一维数组，n个字符串的一维数组构成二维数组。目的就是求这个二维数组列最小值

---

##### 题号：116. 填充每个节点的下一个右侧节点指针

**知识点**：结合二叉树的层次遍历思想和链表的思想

---

##### 题号：977. 有序数组的平方

**知识点**：利用有序数组的性质，使用双指针来实现对原数组的平方的排序

---

##### 题号：52. N皇后 II

**知识点**：这道题的关键是利用一个rows数组，其中rows[n]代表第n行的皇后放在第rows[n]列。利用回溯算法dfs(n,rows)来进行枚举。其中传入的参数n代表[0~n)行的
皇后已经摆好了位置，现在需要考虑第n行的皇后的位置

---

### Day88

##### 题号：19. 删除链表的倒数第N个节点

**知识点**：典型的链表双指针实现

---

##### 题号：295. 数据流的中位数

**知识点**：堆的灵活使用

---

##### 题号：844. 比较含退格的字符串

**知识点**：利用辅助栈，实现思路和判断括号是否有效一致

---

##### 题号：143. 重排链表

**知识点**：将链表遍历出来放在列表，利用首尾指针读出节点并重构链表

---

### Day89

##### 题号：925. 长按键入

**知识点**：用到了字符串的一维动态规划

---

##### 题号：763. 划分字母区间

**知识点**：

暴力思路：记录下每个字符的最左边的位置和最右边的位置，接下来有点类使合并区间;优化一下就是官方解答
简单思路：双指针，看官方解答

---

##### 题号：234. 回文链表

**知识点**：1、存进数组，然后双指针
2、双指针，反转一半的链表

---

##### 题号：1024. 视频拼接

**知识点**：线段问题，排序+贪心

---

### Day90

##### 题号：845. 数组中的最长山脉

**知识点**：

[2,1,4,7,3,2,5]
1、记录下每个位置元素左边小于且呈现递减的元素的个数，例如7的左边小于它且递减的元素个数为[1,4]；同样记录下右边小于该位置且呈递减的元素个数[3,2]；
最长的山脉就是左右最小元素的个数相加再加上1

---

##### 题号：1365. 有多少小于当前数字的数字

**知识点**：排序

---

##### 题号：144. 二叉树的前序遍历

**知识点**：二叉树遍历，关键在于迭代算法

---

##### 题号：1207. 独一无二的出现次数

**知识点**：哈希表简单应用

---

### Day91

##### 题号：129. 求根到叶子节点数字之和

**知识点**：二叉树常规递归

---

##### 题号：463. 岛屿的周长

**知识点**：二维数组简单遍历处理思路题型

---

##### 题号：381. O(1) 时间插入、删除和获取随机元素 - 允许重复

**知识点**：哈希表、Set集合和List的综合设计，官方题解很清楚

---

##### 题号：140. 单词拆分 II

**知识点**：DFS+巧妙的记忆化

---

### Day92

##### 题号：349. 两个数组的交集

**知识点**：排序或集合

---

##### 题号：941. 有效的山脉数组

**知识点**：首先排除空数组、长度小于3的数组和逆序数组。然后找峰值，确保在峰值之前全部是升序，峰值之后全部是降序，一边循环，O(1)空间复杂

---

##### 题号：57. 插入区间

**知识点**：结合56合并区间一起看，本题需要使用一个标志位，标记新区间是否已经插入过，避免出错

---

##### 题号：127. 单词接龙

**知识点**：BFS，DFS不可做？

---

### Day93

##### 题号：1356. 根据数字二进制下 1 的数目排序

**知识点**：排序，关键是求解数字中1的个数，可以移位求

---

##### 题号：327. 区间和的个数

**知识点**：暴力AC

---

##### 题号：122. 买卖股票的最佳时机 II

**知识点**：1、动态规划，dp[i][0]为第i天没有持有股票，dp[i][1]为第i天持有股票；
2、波峰波谷法

---

##### 题号：400. 第N个数字

**知识点**：数学找规律。[1,9]包含9个数字；[10,99]包含2*90个数字；[100,999]包含3*900个数字
先判断出第N个数字是几位数（1，2，3..）,再判断其是第几个。

---

### Day94

##### 题号：31. 下一个排列

**知识点**：如果存在下一个较大的排列，那么肯定是从右到左的递减点，例如7，6，2，5，4，3，1。这里2就是第一个递减点，
此时只需要再从右往左找到第一个大于递减的数交换，并对交换后的进行反转即可。例如3是第一个大于递减点2的数，此时交换后
7，6，3，5，4，2，1，再对3之后的序列进行反转即可

---

##### 题号：514. 自由之路

**知识点**：不太熟悉的DFS变量处理

---

##### 题号：922. 按奇偶排序数组 II

**知识点**：推荐双指针解法。i,j每次指向奇偶位置，也就是每次i,j都移动两位

---

##### 题号：328. 奇偶链表

**知识点**：定义两个奇偶节点，分别存储奇数和偶数的节点，最后将两个拼接即可

---

### Day95

##### 题号：1122. 数组的相对排序

**知识点**：如果存在下一个较大的排列，那么肯定是从右到左的递减点，例如7，6，2，5，4，3，1。这里2就是第一个递减点，
此时只需要再从右往左找到第一个大于递减的数交换，并对交换后的进行反转即可。例如3是第一个大于递减点2的数，此时交换后
7，6，3，5，4，2，1，再对3之后的序列进行反转即可

---

##### 题号：402. 移掉K位数字

**知识点**：有点数学思维，参考官方题解.关键是利用栈去重

---

##### 题号：316. 去除重复字母

**知识点**：基本思路同402，但是要保证每个字符都要在栈中出现一次

---

##### 题号：406. 根据身高重建队列

**知识点**：1、先按照身高从高到低的顺序进行排序，如果身高相同，则按照k从小到大排序。例如[7,0]应该排在[7,1]的前面
2、排序之后进行插入即可,例如排序之后{{7,0},{7,1},{6,1},{5,0},{5,2},{4,4}}
<<<<<<< HEAD
这样插入保证了插入位置k前面的元素刚好有k个大于等于h，且之后插入的元素由于小于h，因此不会对相对位置产生影响

---

### Day96

##### 题号：1030. 距离顺序排列矩阵单元格

**知识点**：先定义出R*C行2列的二维矩阵，然后自定义排序规则即可

---

##### 题号：134. 加油站

**知识点**：朴素思想，首先判断从i出发能不能达到i+1，也就是gas[i]是否大于等于cost[i]；如果满足条件再进行下一步判断。优化技巧是如果从i最远能到j，
那么[i+1,j]之间的都不用判断，这之间的点肯定不能跑一圈

---

##### 题号：283. 移动零

**知识点**：双指针.指针i用来遍历，指针j用来记录非0的元素的个数，先把非0的元素全部移动到前面，然后最后将j之后的元素全部赋值为0

---

##### 题号：160. 相交链表

**知识点**：首先求解出两个链表的长度之差，例如链表A比链表B长2，那么先让A的头指针移动两位后，才开始同时继续移动A的指针和B的指针

---

### Day97

##### 题号：147. 对链表进行插入排序

**知识点**：朴素思路。定义一个先驱节点，用curNode和curNext代表当前遍历到的节点和下一个节点，如果curNode.val<=curNext.val继续遍历即可，否在说明存在逆序，需要将curNext节点插入到前面去。从先驱节点搜索插入位置插入即可

---

##### 题号：148. 排序链表

**知识点**：排序大法

---

##### 题号：242. 有效的字母异位词

**知识点**：哈希数组

---

##### 题号：452. 用最少数量的箭引爆气球

**知识点**：排序，贪心。送分，，，

---

### Day98

##### 题号：222. 完全二叉树的节点个数

**知识点**：暴力递归AC

---

##### 题号：1370. 上升下降字符串

**知识点**：字母的哈希数组，先正序遍历后逆序遍历，重复往返知道数组中全部元素遍历完成

---

##### 题号：164. 最大间距

**知识点**：桶排序算法

---

##### 题号：454. 四数相加 II

**知识点**：DFS+Map<Integer, Map<Integer, Integer>> map记忆化超时；
分组，将A，B的和分为一组存进Map<Integer, Integer>map，键为和，值为该和出现的次数；然后再对C，D的和判断，判断哈希表中是否存在-c-d，如果有则
加上对应次数即可

---

### Day99

##### 题号：493. 翻转对

**知识点**：剑指Offer51，但是为什么不可以合并两个while？

---

##### 题号：976. 三角形的最大周长

**知识点**：排序，利用三角形构成的性质：最短的两条边之和大于第三边

---

##### 题号：767. 重构字符串

**知识点**：先将出现次数最多的字符放在偶数位置（从0开始），然后再放其他的字符。每次跳2位，如果索引大于字符串长度，再将索引置为1

---

##### 题号：72. 编辑距离

**知识点**：字符串的动态规划。有点类似，最长公共子序列。
dp[i][j]代表将word1的[0,i)个字符编辑为word2的[0,j)个字符的距离
可知，如果word1[i]==word2[i]，那么dp[i][j]=dp[i-1][j-1]；
如果不等时，则有三种情况：增、删、改。取其中最小的加一