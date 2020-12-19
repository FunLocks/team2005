# FunLocks2020年 アピールシート

### プロダクト名
CAPUCI (CAsual Predict User CIrcumstance)

### コンセプト
- リアルタイムでの大学内の各場所ごとの混雑具合をマテリアルデザインを用いて可視化
- 1日あたりの人の混雑度のグラフを可視化

### 対象ユーザ
- 未来大生、未来大の教職員など頻繁に未来大を利用する人

### どうやって利用するか
- アプリ起動後にビーコン検知が始まり、使用したい機能（各場所の混雑度の可視化・その日の各場所ごとの人の推移など）

### 推しポイント
- CAPUCIのロゴを作成した
- 機械学習を用いた統計予測

### スクリーンショット(任意)
![image1](https://user-images.githubusercontent.com/66785066/102675179-c1cccd80-41db-11eb-9770-135753064bad.png)
![image2](https://user-images.githubusercontent.com/66785066/102675258-0ce6e080-41dc-11eb-959f-d82085f8f44e.jpg)
![image3](https://user-images.githubusercontent.com/66785066/102675166-b7123880-41db-11eb-94ff-b761bf859ed2.jpg)

## 開発体制
### 役割分担
田島鼓太郎 : フロント側のAPI周りの処理、チームメンバーのサポート
日置竜輔 : beaconの検知、グラフの作成・可視化、README作成
山本晃平 : figmaを用いたデザイン設計、Adobe Illustrator を用いたアプリのロゴ作成、プレゼン資料作成
加藤万理子 : サーバーAPI作成、サンプルデータの生成、機械学習を用いて過去の時間割から混雑を予測し、可視化してHerokuへデプロイ
柿本翔大 : サーバー上のDB構築・処理、現在の混雑状況の表示

### オンライン開発における工夫した点
- 作業時はなるべく作業通話で作業し、常に周りが何の作業をしているのか明確にした
- 議事録を毎週取ることにより、オンライン下でも連絡を密に取れるようにした
- miroを使ってオンラインでもアイデアソンをスムーズに行えるようにした
- Slack、Discordなどのチャット機能を有効活用した
- 進捗報告を毎晩行った
- issueを用いたタスクの管理を行った
- 事前に上流工程を行ってハッカソン当日でスムーズに動けるようにした

## 開発技術(任意)
### 利用したプログラミング言語
フロントエンド : kotlin, html, css, javascript
バックエンド : Python, PostgreSQL

### 利用したフレームワーク・ライブラリ
#### フロントエンド 
Android Studio : (アプリ作成), android-beacon-library : (ビーコン検知), Room Persistence Library : (データベース), retrofit : (Android用HTTP Client), 
gson : (JSONパース), Bootstrap(WEB), amCharts(WEB)

#### バックエンド
Flask : (webAPI), gunicorn : (Heroku), psycopg2 : （Heroku）, SQLAlchemy : （DB）, flask-sqlalchemy : （DB）, pandas : （データ処理）, 
XGBoost : (機械学習), scikit-learn : (機械学習)

### その他開発に使用したツール
figma (UIデザイン), miro (オンラインホワイトボード), Google Doc （議事録の共有）, Discord （チーム内での連絡）, Slack (進捗報告、メンターさんへの質問等)
