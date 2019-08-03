># 確定有限狀態自動機
>
>在計算理論中，確定有限狀態自動機或確定有限自動機（英語：deterministic finite automaton, DFA）是一個能實現狀態轉移的自動機。對於一個給定的屬於該自動機的狀態和一個屬於該自動機字母表 $$\Sigma$$ 的字元，它都能根據事先給定的轉移函式轉移到下一個狀態（這個狀態可以是先前那個狀態）。
>
>## 基礎概念
>
>### 定義
>
>確定有限狀態自動機 $${\mathcal {A}}$$ 是由
>
>* 一個非空有限的狀態集合 $$Q$$
>* 一個輸入字母表 $$\Sigma$$ （非空有限的字元集合）
>* 一個轉移函式 $$\delta :Q\times \Sigma \rightarrow Q$$（例如： $$\delta \left(q,\sigma \right)=p,\left(p,q\in Q,\sigma \in \Sigma \right)$$）
>* 一個開始狀態 $$s\in Q$$
>* 一個接受狀態的集合 $$F\subseteq Q$$
>
>所組成的5-元組。因此一個DFA可以寫成這樣的形式： $${\mathcal  {A}}=\left(Q,\Sigma ,\delta ,s,F\right)$$。
>
>### 工作方式（非正式的語意)
>
>確定有限狀態自動機從起始狀態開始，一個字元接一個字元地讀入一個字串 $$w\in \Sigma ^{*}$$（這裡的 $${}^{*}$$指示Kleene星號算子。），並根據給定的轉移函式一步一步地轉移至下一個狀態。在讀完該字串後，如果該自動機停在一個屬於F的接受狀態，那麼它就接受該字串，反之則拒絕該字串。
>
>### 擴充轉移函式
>
>為了在保證嚴謹的前提下，方便地敘述關於DFA的內容，我們定義如下擴充的轉移函式：$$\delta ^{*}:Q\times \Sigma ^{*}\rightarrow Q$$。
>
>* 其中$$\delta ^{*}\left(q,w\right)$$是自動機從狀態q順序讀入字串w後達到的狀態
>* 擴充轉移函式遞迴的定義為：
>    * $$\delta ^{*}\left(q,\epsilon \right)=q$$
>    * $$ \delta ^{*}\left(q,u\sigma \right)=\delta (\delta ^{*}(q,u),\sigma ),\forall u\in \Sigma ^{*},\sigma \in \Sigma $$
>
>### 工作方式（正式的語意）
>
>對於一個確定有限狀態自動機 $${\mathcal  {A}}=\left(Q,\Sigma ,\delta ,s,F\right)$$，如果 $$ \delta ^{*}\left(s,w\right)\in F$$，我們就說該自動機接受字串w，反之則表明該自動機拒絕字串w。
>
>被一個確定有限自動機接受的語言（或者叫「被辨識的語言」）定義為： $${\mathcal  {L}}({\mathcal  {A}})=\{w\in \Sigma ^{*}|{\mathcal  {A}}~接受字串 ~w\}，$$也就是由所有被接受的字串組成的集合。
>
>## 參考
>
>* [確定有限狀態自動機](https://zh.wikipedia.org/wiki/確定有限狀態自動機)