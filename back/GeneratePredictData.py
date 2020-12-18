#!/usr/bin/python
# -*- coding: utf-8 -*-
"""
学習用データをよさげに生成するためのスクリプト
"""

import pandas as pd
import datetime
import random

class PredictData:
    def __init__(self):
        #講義データ-------------------------
        #令和２年度後期
        #令和元年度前期
        #令和元年度後期
        #平成３０年度前期
        #平成30年度後期
        #-----------------------------



        self.location = pd.DataFrame(columns=['location'])
        self.location = self.location.append({'location':'595'}, ignore_index=True)
        self.location = self.location.append({'location':'594'}, ignore_index=True)
        self.location = self.location.append({'location':'593'}, ignore_index=True)
        self.location = self.location.append({'location':'585'}, ignore_index=True)
        self.location = self.location.append({'location':'584'}, ignore_index=True)
        self.location = self.location.append({'location':'583'}, ignore_index=True)
        self.location = self.location.append({'location':'484'}, ignore_index=True)
        self.location = self.location.append({'location':'363'}, ignore_index=True)
        self.location = self.location.append({'location':'講堂'}, ignore_index=True)
        self.location = self.location.append({'location':'大講義室'}, ignore_index=True)
        return
    
    def Periods(self,year,month):
        #時間割データ--------------------
        timezone = str(year)+'/'+str(month)

        periods = pd.DataFrame(columns=['period','start_time','end_time'])
        periods = periods.append({'period':1,'start_time': timezone+'/18 09:00','end_time':timezone+'/18 10:30'}, ignore_index=True)
        periods = periods.append({'period':2,'start_time':timezone+'/18 10:40','end_time':timezone+'/18 12:10'}, ignore_index=True)
        periods = periods.append({'period':3,'start_time':timezone+'/18 13:10','end_time':timezone+'/18 14:40'}, ignore_index=True)
        periods = periods.append({'period':4,'start_time':timezone+'/18 14:50','end_time':timezone+'/18 16:20'}, ignore_index=True)
        periods = periods.append({'period':5,'start_time':timezone+'/18 16:30','end_time':timezone+'/18 18:00'}, ignore_index=True)
        #------------------------------
        return periods
    
    def GenerateStudents(self,lectures,year,month,name):
        df_location = pd.DataFrame(columns=['location','time','students'])
        df_period = self.Periods(year,month)

        df = (pd.merge(lectures,df_period,on='period')) #このlecturesを引数にすれば良い感じに生成できそう
        print(df)

        
        td_50m = datetime.timedelta(minutes=30)
        for _, row in self.location.iterrows():
            d = datetime.datetime(year,month,18,00,00) #2020年12月18日0時０分
            for _ in range(48):

                #その曜日にその教室でやってる授業一覧
                info_loc = df[df['place']==row['location']]

                #その曜日にその教室で授業ひとつ以上
                if len(info_loc.index) != 0: 
                    for _,row_loc in info_loc.iterrows():
                        lec_start = datetime.datetime.strptime(row_loc['start_time'],'%Y/%m/%d %H:%M')
                        lec_end = datetime.datetime.strptime(row_loc['end_time'],'%Y/%m/%d %H:%M')
                        if lec_start <=d and lec_end >=d: #その場所で講義時間内なら
                            df_location = df_location.append({'location':row['location'], 'time':d,'students':random.randint(row_loc['max_students']-10,row_loc['max_students'])}, ignore_index=True)
                                        
                        elif datetime.datetime(year,month,18,8,0) >= d or datetime.datetime(year,month,18,22,0) <= d: #教室がしまってる朝8時まで夜２２時以降
                            df_location = df_location.append({'location':row['location'], 'time':d,'students':0}, ignore_index=True)
                            
                        else:
                            df_location = df_location.append({'location':row['location'], 'time':d,'students':random.randint(0,3)}, ignore_index=True) #教室あいてるけど授業時間外
                        break
                    
                else:
                    #その曜日にその教室で授業はなし
                    if datetime.datetime(year,month,18,0,0) <= d and datetime.datetime(year,month,18,8,0) >= d and datetime.datetime(2020,12,18,22,0) <= d: #教室がしまってる朝8時まで夜２２時以降
                        df_location = df_location.append({'location':row['location'], 'time':d,'students':0}, ignore_index=True)
                        
                    else:
                        df_location = df_location.append({'location':row['location'], 'time':d,'students':random.randint(0,3)}, ignore_index=True) #教室あいてるけど授業時間外
                    
                d = d + td_50m 
        
        df_location.to_csv('sampledata/'+'TrainingData/'+name+'.csv')
        return df_location
    
    def MakeTestData(self,year,month):
        test = pd.DataFrame(columns=['location','time'])
        td_50m = datetime.timedelta(minutes=30)
        for _, row in self.location.iterrows():
            d = datetime.datetime(year,month,18,00,00) #2020年12月18日0時０分
            for _ in range(48):
                test = test.append({'location':row['location'], 'time':d}, ignore_index=True)
                d = d + td_50m

        test.to_csv('sampledata/test.csv')
        return


    
    def Data2020Pre(self):
        """
        2020年度前期
        """
        lectures = pd.DataFrame(columns=['name','max_students','period','weekday','place'])
        #令和２年度前期
        lectures = lectures.append({'name':'線形代数学１','max_students':80,'period':1,'weekday':'Mon','place':'593'}, ignore_index=True)
        lectures = lectures.append({'name':'解析学１','max_students':80,'period':1,'weekday':'Mon','place':'594'}, ignore_index=True)
        lectures = lectures.append({'name':'情報デザイン１E','max_students':20,'period':1,'weekday':'Mon','place':'363'}, ignore_index=True)
        lectures = lectures.append({'name':'情報デザイン１F','max_students':20,'period':1,'weekday':'Mon','place':'484'}, ignore_index=True)
        #lectures = lectures.append({'name':'応用数学２','max_students':60,'period':1,'weekday':'Mon','place':'R791'}, ignore_index=True) 研究棟は省く
        lectures = lectures.append({'name':'複雑系計算論','max_students':60,'period':1,'weekday':'Mon','place':'585'}, ignore_index=True)
        lectures = lectures.append({'name':'数学総合演習１A','max_students':60,'period':2,'weekday':'Mon','place':'593'}, ignore_index=True)
        lectures = lectures.append({'name':'余暇と健康２','max_students':80,'period':2,'weekday':'Mon','place':'体育館'}, ignore_index=True)
        lectures = lectures.append({'name':'数学総合演習１I','max_students':80,'period':2,'weekday':'Mon','place':'594'}, ignore_index=True)
        lectures = lectures.append({'name':'情報デザイン演習１E','max_students':20,'period':2,'weekday':'Mon','place':'363'}, ignore_index=True)
        lectures = lectures.append({'name':'情報デザイン演習１F','max_students':20,'period':2,'weekday':'Mon','place':'484'}, ignore_index=True)
        lectures = lectures.append({'name':'ネットワーク通信理論','max_students':80,'period':2,'weekday':'Mon','place':'595'}, ignore_index=True)
        lectures = lectures.append({'name':'画像工学','max_students':100,'period':2,'weekday':'Mon','place':'大講義室'}, ignore_index=True)
        lectures = lectures.append({'name':'信号処理基礎','max_students':60,'period':2,'weekday':'Mon','place':'585'}, ignore_index=True)
        lectures = lectures.append({'name':'言語と社会','max_students':100,'period':2,'weekday':'Mon','place':'講堂'}, ignore_index=True)
        lectures = lectures.append({'name':'情報機器概論I','max_students':80,'period':3,'weekday':'Mon','place':'594'}, ignore_index=True)
        #lectures = lectures.append({'name':'形式言語とオートマトン','max_students':60,'period':3,'weekday':'Mon','place':'R791'}, ignore_index=True)
        lectures = lectures.append({'name':'複雑系科学トピックス','max_students':60,'period':3,'weekday':'Mon','place':'595'}, ignore_index=True)
        lectures = lectures.append({'name':'コンピュータと教育','max_students':100,'period':3,'weekday':'Mon','place':'講堂'}, ignore_index=True)
        #lectures = lectures.append({'name':'課題研究３','max_students':60,'period':3,'weekday':'Mon','place':'講堂'}, ignore_index=True)
        lectures = lectures.append({'name':'アカデミックリテラシー１','max_students':80,'period':3,'weekday':'Mon','place':'593'}, ignore_index=True)
        lectures = lectures.append({'name':'キャリアガイダンス','max_students':100,'period':3,'weekday':'Mon','place':'講堂'}, ignore_index=True)
        lectures = lectures.append({'name':'キャリアガイダンス','max_students':100,'period':4,'weekday':'Mon','place':'講堂'}, ignore_index=True)
        #lectures = lectures.append({'name':'ICT演習','max_students':100,'period':4,'weekday':'Mon','place':'講堂'}, ignore_index=True)
        #lectures = lectures.append({'name':'ICT演習','max_students':100,'period':5,'weekday':'Mon','place':'講堂'}, ignore_index=True)

        return lectures

    def Data2020Late(self):
        """
        2020年度後期
        """
        lectures = pd.DataFrame(columns=['name','max_students','period','weekday','place'])
        lectures = lectures.append({'name':'線形代数学２','max_students':80,'period':1,'weekday':'Mon','place':'なし'}, ignore_index=True)
        lectures = lectures.append({'name':'電子工学基礎','max_students':120,'period':1,'weekday':'Mon','place':'なし'}, ignore_index=True)
        lectures = lectures.append({'name':'人工知能基礎','max_students':80,'period':1,'weekday':'Mon','place':'なし'}, ignore_index=True)
        lectures = lectures.append({'name':'情報表現基礎３E','max_students':20,'period':1,'weekday':'Mon','place':'484'}, ignore_index=True)
        lectures = lectures.append({'name':'情報表現基礎３F','max_students':20,'period':1,'weekday':'Mon','place':'584'}, ignore_index=True)
        lectures = lectures.append({'name':'確率論と情報理論','max_students':60,'period':1,'weekday':'Mon','place':'なし'}, ignore_index=True)
        lectures = lectures.append({'name':'モデル化と要求開発','max_students':40,'period':1,'weekday':'Mon','place':'494'}, ignore_index=True)
        lectures = lectures.append({'name':'モデル化と要求開発','max_students':40,'period':1,'weekday':'Mon','place':'495'}, ignore_index=True)
        #lectures = lectures.append({'name':'アカデミックリテラシー２','max_students':80,'period':1,'weekday':'Mon','place':'494'}, ignore_index=True)
        lectures = lectures.append({'name':'解析学２A','max_students':80,'period':2,'weekday':'Mon','place':'なし'}, ignore_index=True)
        lectures = lectures.append({'name':'解析学２E','max_students':80,'period':2,'weekday':'Mon','place':'なし'}, ignore_index=True)
        lectures = lectures.append({'name':'線形代数学２I','max_students':80,'period':2,'weekday':'Mon','place':'なし'}, ignore_index=True)
        lectures = lectures.append({'name':'情報表現基礎演習E','max_students':20,'period':2,'weekday':'Mon','place':'484'}, ignore_index=True)
        lectures = lectures.append({'name':'情報表現基礎演習F','max_students':20,'period':2,'weekday':'Mon','place':'584'}, ignore_index=True)
        lectures = lectures.append({'name':'情報代数楽と符号理論G','max_students':60,'period':2,'weekday':'Mon','place':'なし'}, ignore_index=True)
        lectures = lectures.append({'name':'微分方程式','max_students':60,'period':2,'weekday':'Mon','place':'なし'}, ignore_index=True)
        lectures = lectures.append({'name':'ニューロコンピューティング','max_students':120,'period':2,'weekday':'Mon','place':'大講義室'}, ignore_index=True)
        #lectures = lectures.append({'name':'IT・ビジネスモデル','max_students':80,'period':2,'weekday':'Mon','place':'E工房'}, ignore_index=True)
        lectures = lectures.append({'name':'数学総合演習２A','max_students':80,'period':3,'weekday':'Mon','place':'なし'}, ignore_index=True)
        lectures = lectures.append({'name':'解析学２I','max_students':80,'period':3,'weekday':'Mon','place':'なし'}, ignore_index=True)
        lectures = lectures.append({'name':'システム工学','max_students':80,'period':3,'weekday':'Mon','place':'大講義室'}, ignore_index=True)
        lectures = lectures.append({'name':'センサ工学','max_students':100,'period':3,'weekday':'Mon','place':'なし'}, ignore_index=True)
        lectures = lectures.append({'name':'経済システム入門','max_students':60,'period':3,'weekday':'Mon','place':'なし'}, ignore_index=True)
        lectures = lectures.append({'name':'キャリアガイダンス','max_students':100,'period':3,'weekday':'Mon','place':'講堂'}, ignore_index=True)

        return lectures
    
    def Data2019Pre(self):
        """
        2019年度前期
        """
        lectures = pd.DataFrame(columns=['name','max_students','period','weekday','place'])
        lectures = lectures.append({'name':'線形代数学１','max_students':80,'period':1,'weekday':'Mon','place':'593'}, ignore_index=True)
        lectures = lectures.append({'name':'解析学１E','max_students':80,'period':1,'weekday':'Mon','place':'594'}, ignore_index=True)
        #lectures = lectures.append({'name':'解析学１I','max_students':80,'period':1,'weekday':'Mon','place':'R791'}, ignore_index=True)
        lectures = lectures.append({'name':'アルゴリズムとデータ構造A','max_students':80,'period':1,'weekday':'Mon','place':'493'}, ignore_index=True)
        lectures = lectures.append({'name':'応用数学２J','max_students':60,'period':1,'weekday':'Mon','place':'595'}, ignore_index=True)
        lectures = lectures.append({'name':'複雑系計算論','max_students':60,'period':1,'weekday':'Mon','place':'484'}, ignore_index=True)
        #lectures = lectures.append({'name':'情報ネットワーク特論２','max_students':80,'period':1,'weekday':'Mon','place':'593'}, ignore_index=True)
        lectures = lectures.append({'name':'数学総合演習１A','max_students':80,'period':2,'weekday':'Mon','place':'593'}, ignore_index=True)
        #lectures = lectures.append({'name':'余暇と健康２G','max_students':80,'period':2,'weekday':'Mon','place':'体育館'}, ignore_index=True)
        lectures = lectures.append({'name':'数学総合演習１I','max_students':80,'period':2,'weekday':'Mon','place':'594'}, ignore_index=True)
        lectures = lectures.append({'name':'アルゴリズムとデータ構造G','max_students':60,'period':2,'weekday':'Mon','place':'493'}, ignore_index=True)
        lectures = lectures.append({'name':'ネットワーク通信理論','max_students':80,'period':2,'weekday':'Mon','place':'595'}, ignore_index=True)
        lectures = lectures.append({'name':'画像工学','max_students':120,'period':2,'weekday':'Mon','place':'大講義室'}, ignore_index=True)
        lectures = lectures.append({'name':'信号処理基礎','max_students':60,'period':2,'weekday':'Mon','place':'585'}, ignore_index=True)
        #lectures = lectures.append({'name':'認知システム通論','max_students':80,'period':2,'weekday':'Mon','place':'R782'}, ignore_index=True)
        #lectures = lectures.append({'name':'形式言語とオートマトン','max_students':80,'period':3,'weekday':'Mon','place':'R791'}, ignore_index=True)
        lectures = lectures.append({'name':'複雑系科学トピックス','max_students':60,'period':3,'weekday':'Mon','place':'595'}, ignore_index=True)
        lectures = lectures.append({'name':'コンピュータと教育','max_students':100,'period':3,'weekday':'Mon','place':'大講義室'}, ignore_index=True)
        #lectures = lectures.append({'name':'課題研究３','max_students':80,'period':3,'weekday':'Mon','place':'593'}, ignore_index=True)
        #lectures = lectures.append({'name':'アカデミックリテラシー','max_students':80,'period':3,'weekday':'Mon','place':'593'}, ignore_index=True)
        #lectures = lectures.append({'name':'キャリアガイダンス','max_students':80,'period':3,'weekday':'Mon','place':'593'}, ignore_index=True)
        return lectures

    def Data2019Late(self):
        """
        2019年度後期
        """
        lectures = pd.DataFrame(columns=['name','max_students','period','weekday','place'])
        lectures = lectures.append({'name':'線形代数学２','max_students':80,'period':1,'weekday':'Mon','place':'593'}, ignore_index=True)
        #lectures = lectures.append({'name':'電子工学基礎','max_students':100,'period':1,'weekday':'Mon','place':'R791'}, ignore_index=True)
        lectures = lectures.append({'name':'情報表現基礎３E','max_students':20,'period':1,'weekday':'Mon','place':'484'}, ignore_index=True)
        lectures = lectures.append({'name':'情報表現基礎３F','max_students':20,'period':1,'weekday':'Mon','place':'583'}, ignore_index=True)
        lectures = lectures.append({'name':'確率論と情報理論','max_students':60,'period':1,'weekday':'Mon','place':'595'}, ignore_index=True)
        lectures = lectures.append({'name':'モデル化と要求開発','max_students':80,'period':1,'weekday':'Mon','place':'493'}, ignore_index=True)
        lectures = lectures.append({'name':'物理と情報処理１','max_students':60,'period':1,'weekday':'Mon','place':'594'}, ignore_index=True)
        lectures = lectures.append({'name':'解析学２A','max_students':80,'period':2,'weekday':'Mon','place':'594'}, ignore_index=True)
        #lectures = lectures.append({'name':'余暇と健康２G','max_students':40,'period':2,'weekday':'Mon','place':'体育館'}, ignore_index=True)
        lectures = lectures.append({'name':'線形代数学２I','max_students':80,'period':2,'weekday':'Mon','place':'595'}, ignore_index=True)
        lectures = lectures.append({'name':'人工知能基礎A','max_students':80,'period':2,'weekday':'Mon','place':'593'}, ignore_index=True)
        lectures = lectures.append({'name':'情報表現基礎演習３E','max_students':20,'period':2,'weekday':'Mon','place':'484'}, ignore_index=True)
        lectures = lectures.append({'name':'情報表現基礎演習３F','max_students':20,'period':2,'weekday':'Mon','place':'584'}, ignore_index=True)
        #lectures = lectures.append({'name':'プロジェクトマネージメント','max_students':100,'period':2,'weekday':'Mon','place':'594'}, ignore_index=True)
        lectures = lectures.append({'name':'ニューロコンピューティング','max_students':100,'period':2,'weekday':'Mon','place':'493'}, ignore_index=True)
        #lectures = lectures.append({'name':'ビジネススキル','max_students':80,'period':2,'weekday':'Mon','place':'594'}, ignore_index=True)
        #lectures = lectures.append({'name':'アカデミックリテラシー','max_students':80,'period':2,'weekday':'Mon','place':'594'}, ignore_index=True)
        lectures = lectures.append({'name':'数学総合演習２A','max_students':80,'period':3,'weekday':'Mon','place':'593'}, ignore_index=True)
        lectures = lectures.append({'name':'解析学２E','max_students':80,'period':3,'weekday':'Mon','place':'594'}, ignore_index=True)
        lectures = lectures.append({'name':'解析学２I','max_students':80,'period':3,'weekday':'Mon','place':'594'}, ignore_index=True)
        #lectures = lectures.append({'name':'解析学２A','max_students':80,'period':3,'weekday':'Mon','place':'R791'}, ignore_index=True)
        lectures = lectures.append({'name':'システム工学','max_students':80,'period':3,'weekday':'Mon','place':'493'}, ignore_index=True)
        lectures = lectures.append({'name':'センサ工学','max_students':100,'period':3,'weekday':'Mon','place':'大講義室'}, ignore_index=True)
        lectures = lectures.append({'name':'経済システム入門','max_students':60,'period':3,'weekday':'Mon','place':'595'}, ignore_index=True)
        
        return lectures

    def Data2018Pre(self):
        """
        2018年度前期
        """
        lectures = pd.DataFrame(columns=['name','max_students','period','weekday','place'])
        lectures = lectures.append({'name':'線形代数学１','max_students':80,'period':1,'weekday':'Mon','place':'593'}, ignore_index=True)
        lectures = lectures.append({'name':'解析学１E','max_students':80,'period':1,'weekday':'Mon','place':'594'}, ignore_index=True)
        #lectures = lectures.append({'name':'解析学１I','max_students':80,'period':1,'weekday':'Mon','place':'R791'}, ignore_index=True)
        lectures = lectures.append({'name':'アルゴリズムとデータ構造A','max_students':80,'period':1,'weekday':'Mon','place':'493'}, ignore_index=True)
        lectures = lectures.append({'name':'応用数学２J','max_students':60,'period':1,'weekday':'Mon','place':'595'}, ignore_index=True)
        lectures = lectures.append({'name':'複雑系計算論','max_students':60,'period':1,'weekday':'Mon','place':'484'}, ignore_index=True)
        #lectures = lectures.append({'name':'情報ネットワーク特論２','max_students':80,'period':1,'weekday':'Mon','place':'593'}, ignore_index=True)
        lectures = lectures.append({'name':'数学総合演習１A','max_students':80,'period':2,'weekday':'Mon','place':'593'}, ignore_index=True)
        #lectures = lectures.append({'name':'余暇と健康２G','max_students':80,'period':2,'weekday':'Mon','place':'体育館'}, ignore_index=True)
        lectures = lectures.append({'name':'数学総合演習１I','max_students':80,'period':2,'weekday':'Mon','place':'594'}, ignore_index=True)
        lectures = lectures.append({'name':'アルゴリズムとデータ構造G','max_students':60,'period':2,'weekday':'Mon','place':'493'}, ignore_index=True)
        lectures = lectures.append({'name':'ネットワーク通信理論','max_students':80,'period':2,'weekday':'Mon','place':'595'}, ignore_index=True)
        lectures = lectures.append({'name':'画像工学','max_students':120,'period':2,'weekday':'Mon','place':'大講義室'}, ignore_index=True)
        lectures = lectures.append({'name':'信号処理基礎','max_students':60,'period':2,'weekday':'Mon','place':'585'}, ignore_index=True)
        #lectures = lectures.append({'name':'認知システム通論','max_students':80,'period':2,'weekday':'Mon','place':'R782'}, ignore_index=True)
        #lectures = lectures.append({'name':'形式言語とオートマトン','max_students':80,'period':3,'weekday':'Mon','place':'R791'}, ignore_index=True)
        lectures = lectures.append({'name':'複雑系科学トピックス','max_students':60,'period':3,'weekday':'Mon','place':'595'}, ignore_index=True)
        lectures = lectures.append({'name':'コンピュータと教育','max_students':100,'period':3,'weekday':'Mon','place':'大講義室'}, ignore_index=True)
        #lectures = lectures.append({'name':'課題研究３','max_students':80,'period':3,'weekday':'Mon','place':'593'}, ignore_index=True)
        #lectures = lectures.append({'name':'アカデミックリテラシー','max_students':80,'period':3,'weekday':'Mon','place':'593'}, ignore_index=True)
        #lectures = lectures.append({'name':'キャリアガイダンス','max_students':80,'period':3,'weekday':'Mon','place':'593'}, ignore_index=True)
 
        return lectures

    def Data2018Late(self):
        """
        2018年度後期
        """
        lectures = pd.DataFrame(columns=['name','max_students','period','weekday','place'])
        lectures = lectures.append({'name':'線形代数学２','max_students':80,'period':1,'weekday':'Mon','place':'593'}, ignore_index=True)
        #lectures = lectures.append({'name':'電子工学基礎','max_students':100,'period':1,'weekday':'Mon','place':'R791'}, ignore_index=True)
        lectures = lectures.append({'name':'情報表現基礎３E','max_students':20,'period':1,'weekday':'Mon','place':'484'}, ignore_index=True)
        lectures = lectures.append({'name':'情報表現基礎３F','max_students':20,'period':1,'weekday':'Mon','place':'583'}, ignore_index=True)
        lectures = lectures.append({'name':'確率論と情報理論','max_students':60,'period':1,'weekday':'Mon','place':'595'}, ignore_index=True)
        lectures = lectures.append({'name':'モデル化と要求開発','max_students':80,'period':1,'weekday':'Mon','place':'493'}, ignore_index=True)
        lectures = lectures.append({'name':'物理と情報処理１','max_students':60,'period':1,'weekday':'Mon','place':'594'}, ignore_index=True)
        lectures = lectures.append({'name':'解析学２A','max_students':80,'period':2,'weekday':'Mon','place':'594'}, ignore_index=True)
        #lectures = lectures.append({'name':'余暇と健康２G','max_students':40,'period':2,'weekday':'Mon','place':'体育館'}, ignore_index=True)
        lectures = lectures.append({'name':'線形代数学２I','max_students':80,'period':2,'weekday':'Mon','place':'595'}, ignore_index=True)
        lectures = lectures.append({'name':'人工知能基礎A','max_students':80,'period':2,'weekday':'Mon','place':'593'}, ignore_index=True)
        lectures = lectures.append({'name':'情報表現基礎演習３E','max_students':20,'period':2,'weekday':'Mon','place':'484'}, ignore_index=True)
        lectures = lectures.append({'name':'情報表現基礎演習３F','max_students':20,'period':2,'weekday':'Mon','place':'584'}, ignore_index=True)
        #lectures = lectures.append({'name':'プロジェクトマネージメント','max_students':100,'period':2,'weekday':'Mon','place':'594'}, ignore_index=True)
        lectures = lectures.append({'name':'ニューロコンピューティング','max_students':100,'period':2,'weekday':'Mon','place':'493'}, ignore_index=True)
        #lectures = lectures.append({'name':'ビジネススキル','max_students':80,'period':2,'weekday':'Mon','place':'594'}, ignore_index=True)
        #lectures = lectures.append({'name':'アカデミックリテラシー','max_students':80,'period':2,'weekday':'Mon','place':'594'}, ignore_index=True)
        lectures = lectures.append({'name':'数学総合演習２A','max_students':80,'period':3,'weekday':'Mon','place':'593'}, ignore_index=True)
        lectures = lectures.append({'name':'解析学２E','max_students':80,'period':3,'weekday':'Mon','place':'594'}, ignore_index=True)
        lectures = lectures.append({'name':'解析学２I','max_students':80,'period':3,'weekday':'Mon','place':'594'}, ignore_index=True)
        #lectures = lectures.append({'name':'解析学２A','max_students':80,'period':3,'weekday':'Mon','place':'R791'}, ignore_index=True)
        lectures = lectures.append({'name':'システム工学','max_students':80,'period':3,'weekday':'Mon','place':'493'}, ignore_index=True)
        lectures = lectures.append({'name':'センサ工学','max_students':100,'period':3,'weekday':'Mon','place':'大講義室'}, ignore_index=True)
        lectures = lectures.append({'name':'経済システム入門','max_students':60,'period':3,'weekday':'Mon','place':'595'}, ignore_index=True)
        
        return lectures

if __name__ == '__main__':
    maru = PredictData()
    result = maru.GenerateStudents(maru.Data2020Pre(),2020,5,'2020_Pre')
    print(result)

    result = maru.GenerateStudents(maru.Data2020Late(),2020,12,'2020_Late')
    print(result)

    result = maru.GenerateStudents(maru.Data2019Pre(),2019,5,'2019_Pre')
    print(result)
    
    result = maru.GenerateStudents(maru.Data2019Late(),2019,12,'2019_Late')
    print(result)

    result = maru.GenerateStudents(maru.Data2018Pre(),2018,5,'2018_Pre')
    print(result)

    result = maru.GenerateStudents(maru.Data2018Late(),2018,12,'2018_Late')
    print(result)
    
    maru.MakeTestData(2020,12)