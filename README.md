# PedometerApp
万歩計のアプリ

## UIコンポーネントの粒度について
- atoms
    - テキストやボタンなどのUIの最小構成。汎用性は高く保つ
    - アプリ内の個別のモデルには依存しないようにする
- molecules
    - atomsに個別のデザインを適用したり、文言を固定したりある程度使用用途を明確にする
    - その他atomsの2,3程度の個数で構成されるものをここで定義する
    - アプリ内の個別のモデルには依存しないようにする（プリミティブな値やStringなどのみに依存するようにさせる）
- organisms
    - ある特定のまとまりのあるUIパーツを定義する。中身が入った時に単一でUI的に意味があるものにする
    - アプリ内の個別のモデルに依存しても良い
    - ダイアログのうち汎用性のあるものはこの粒度とする
- templates
    - 画面要素として具体的なパラメータを入れたらpagesになるようにする
    - 実質的にtemplatesが各画面のUIの定義となる。ただしViewModelには依存しないようにすること（templates単独でPreviewを可能にするため）
    - ダイアログのうち文言などを固定して他で使いまわせないものもこの粒度とする
    - 命名としてpostfixにTemplateをつけること
- pages
    - ViewModelを取得してtemplatesのパラメータに実際の値を入れる
    - ダイアログの表示コントロールもここで実施する
    - orbit-mviの副作用の処理もここでおこなう（補足：orbit-mviというMVIライブラリを使ったのでそのライブラリ特有処理のこと）
    - Preview関数は不要
    - 命名としてpostfixにPageをつけること


参考:https://techlife.cookpad.com/entry/2021/12/17/103000


https://tech.mirrativ.stream/entry/2023/02/14/103911

https://httpie.io/



