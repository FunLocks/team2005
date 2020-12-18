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
        self.lectures = pd.DataFrame(columns=['name','max_students','period','weekday','place'])
        #令和２年度前期
        self.lectures = self.lectures.append({'name':'線形代数学１','max_students':80,'period':1,'weekday':'Mon','place':'593'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'解析学１','max_students':80,'period':1,'weekday':'Mon','place':'594'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'情報デザイン１E','max_students':20,'period':1,'weekday':'Mon','place':'363'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'情報デザイン１F','max_students':20,'period':1,'weekday':'Mon','place':'484'}, ignore_index=True)
        #self.lectures = self.lectures.append({'name':'応用数学２','max_students':60,'period':1,'weekday':'Mon','place':'R791'}, ignore_index=True) 研究棟は省く
        self.lectures = self.lectures.append({'name':'複雑系計算論','max_students':60,'period':1,'weekday':'Mon','place':'585'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'数学総合演習１A','max_students':60,'period':2,'weekday':'Mon','place':'593'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'余暇と健康２','max_students':80,'period':2,'weekday':'Mon','place':'体育館'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'数学総合演習１I','max_students':80,'period':2,'weekday':'Mon','place':'594'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'情報デザイン演習１E','max_students':20,'period':2,'weekday':'Mon','place':'363'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'情報デザイン演習１F','max_students':20,'period':2,'weekday':'Mon','place':'484'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'ネットワーク通信理論','max_students':80,'period':2,'weekday':'Mon','place':'595'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'画像工学','max_students':100,'period':2,'weekday':'Mon','place':'大講義室'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'信号処理基礎','max_students':60,'period':2,'weekday':'Mon','place':'585'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'言語と社会','max_students':100,'period':2,'weekday':'Mon','place':'講堂'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'情報機器概論I','max_students':80,'period':3,'weekday':'Mon','place':'594'}, ignore_index=True)
        #self.lectures = self.lectures.append({'name':'形式言語とオートマトン','max_students':60,'period':3,'weekday':'Mon','place':'R791'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'複雑系科学トピックス','max_students':60,'period':3,'weekday':'Mon','place':'595'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'コンピュータと教育','max_students':100,'period':3,'weekday':'Mon','place':'講堂'}, ignore_index=True)
        #self.lectures = self.lectures.append({'name':'課題研究３','max_students':60,'period':3,'weekday':'Mon','place':'講堂'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'アカデミックリテラシー１','max_students':80,'period':3,'weekday':'Mon','place':'593'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'キャリアガイダンス','max_students':100,'period':3,'weekday':'Mon','place':'講堂'}, ignore_index=True)
        self.lectures = self.lectures.append({'name':'キャリアガイダンス','max_students':100,'period':4,'weekday':'Mon','place':'講堂'}, ignore_index=True)
        #self.lectures = self.lectures.append({'name':'ICT演習','max_students':100,'period':4,'weekday':'Mon','place':'講堂'}, ignore_index=True)
        #self.lectures = self.lectures.append({'name':'ICT演習','max_students':100,'period':5,'weekday':'Mon','place':'講堂'}, ignore_index=True)
        #令和２年度後期
        #令和元年度前期
        #令和元年度後期
        #平成３０年度前期
        #平成30年度後期
        #-----------------------------

        #時間割データ--------------------
        self.periods = pd.DataFrame(columns=['period','start_time','end_time'])
        self.periods = self.periods.append({'period':1,'start_time':'2020/12/18 09:00','end_time':'2020/12/18 10:30'}, ignore_index=True)
        self.periods = self.periods.append({'period':2,'start_time':'2020/12/18 10:40','end_time':'2020/12/18 12:10'}, ignore_index=True)
        self.periods = self.periods.append({'period':3,'start_time':'2020/12/18 13:10','end_time':'2020/12/18 14:40'}, ignore_index=True)
        self.periods = self.periods.append({'period':4,'start_time':'2020/12/18 14:50','end_time':'2020/12/18 16:20'}, ignore_index=True)
        self.periods = self.periods.append({'period':5,'start_time':'2020/12/18 16:30','end_time':'2020/12/18 18:00'}, ignore_index=True)
        

        #------------------------------

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
    
    def GenerateStudents(self):
        df_location = pd.DataFrame(columns=['location','time','students'])

        df = (pd.merge(self.lectures,self.periods,on='period')) #このself.lecturesを引数にすれば良い感じに生成できそう
        print(df)

        
        td_50m = datetime.timedelta(minutes=30)
        for index, row in self.location.iterrows():
            d = datetime.datetime(2020,12,18,00,00) #2020年12月18日0時０分
            for i in range(48):

                #その曜日にその教室でやってる授業一覧
                info_loc = df[df['place']==row['location']]

                #その曜日にその教室で授業ひとつ以上
                if len(info_loc.index) != 0: 
                    for index_loc,row_loc in info_loc.iterrows():
                        lec_start = datetime.datetime.strptime(row_loc['start_time'],'%Y/%m/%d %H:%M')
                        lec_end = datetime.datetime.strptime(row_loc['end_time'],'%Y/%m/%d %H:%M')
                        if lec_start <=d and lec_end >=d: #その場所で講義時間内なら
                            df_location = df_location.append({'location':row['location'], 'time':d,'students':random.randint(row_loc['max_students']-10,row_loc['max_students'])}, ignore_index=True)
                                        
                        elif datetime.datetime(2020,12,18,8,0) >= d or datetime.datetime(2020,12,18,22,0) <= d: #教室がしまってる朝8時まで夜２２時以降
                            df_location = df_location.append({'location':row['location'], 'time':d,'students':0}, ignore_index=True)
                            
                        else:
                            df_location = df_location.append({'location':row['location'], 'time':d,'students':random.randint(0,3)}, ignore_index=True) #教室あいてるけど授業時間外
                        break
                    
                else:
                    #その曜日にその教室で授業はなし
                    if datetime.datetime(2020,12,18,0,0) <= d and datetime.datetime(2020,12,18,8,0) >= d and datetime.datetime(2020,12,18,22,0) <= d: #教室がしまってる朝8時まで夜２２時以降
                        df_location = df_location.append({'location':row['location'], 'time':d,'students':0}, ignore_index=True)
                        
                    else:
                        df_location = df_location.append({'location':row['location'], 'time':d,'students':random.randint(0,3)}, ignore_index=True) #教室あいてるけど授業時間外
                    
                d = d + td_50m 
        return df_location



if __name__ == '__main__':
    maru = PredictData()
    result = maru.GenerateStudents()
    result.to_csv('sampledata/TrainingData.csv')
    print(result)