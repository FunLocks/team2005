#!/usr/bin/python
# -*- coding: utf-8 -*-
"""
学習用データをよさげに生成するためのスクリプト
"""

import pandas as pd
import datetime

class PredictData:
    def __init__(self):
        #講義データ-------------------------
        self.lectures = pd.DataFrame(columns=['name','max_students','period','weekday','place'])
        #令和２年度前期
        self.lectures = self.lectures.append({'name':'線形代数学１','max_students':80,'period':1,'weekday':'Mon','place':'593'})
        self.lectures = self.lectures.append({'name':'解析学１','max_students':80,'period':1,'weekday':'Mon','place':'594'})
        self.lectures = self.lectures.append({'name':'情報デザイン１E','max_students':20,'period':1,'weekday':'Mon','place':'363'})
        self.lectures = self.lectures.append({'name':'情報デザイン１F','max_students':20,'period':1,'weekday':'Mon','place':'484'})
        #self.lectures = self.lectures.append({'name':'応用数学２','max_students':60,'period':1,'weekday':'Mon','place':'R791'}) 研究棟は省く
        self.lectures = self.lectures.append({'name':'複雑系計算論','max_students':60,'period':1,'weekday':'Mon','place':'585'})
        self.lectures = self.lectures.append({'name':'数学総合演習１A','max_students':60,'period':2,'weekday':'Mon','place':'593'})
        self.lectures = self.lectures.append({'name':'余暇と健康２','max_students':80,'period':2,'weekday':'Mon','place':'体育館'})
        self.lectures = self.lectures.append({'name':'数学総合演習１I','max_students':80,'period':2,'weekday':'Mon','place':'594'})
        self.lectures = self.lectures.append({'name':'情報デザイン演習１E','max_students':20,'period':2,'weekday':'Mon','place':'363'})
        self.lectures = self.lectures.append({'name':'情報デザイン演習１F','max_students':20,'period':2,'weekday':'Mon','place':'484'})
        self.lectures = self.lectures.append({'name':'ネットワーク通信理論','max_students':80,'period':2,'weekday':'Mon','place':'595'})
        self.lectures = self.lectures.append({'name':'画像工学','max_students':100,'period':2,'weekday':'Mon','place':'大講義室'})
        self.lectures = self.lectures.append({'name':'信号処理基礎','max_students':60,'period':2,'weekday':'Mon','place':'585'})
        self.lectures = self.lectures.append({'name':'言語と社会','max_students':100,'period':2,'weekday':'Mon','place':'講堂'})
        self.lectures = self.lectures.append({'name':'情報機器概論I','max_students':80,'period':3,'weekday':'Mon','place':'594'})
        #self.lectures = self.lectures.append({'name':'形式言語とオートマトン','max_students':60,'period':3,'weekday':'Mon','place':'R791'})
        self.lectures = self.lectures.append({'name':'複雑系科学トピックス','max_students':60,'period':3,'weekday':'Mon','place':'595'})
        self.lectures = self.lectures.append({'name':'コンピュータと教育','max_students':100,'period':3,'weekday':'Mon','place':'講堂'})
        #self.lectures = self.lectures.append({'name':'課題研究３','max_students':60,'period':3,'weekday':'Mon','place':'講堂'})
        self.lectures = self.lectures.append({'name':'アカデミックリテラシー１','max_students':80,'period':3,'weekday':'Mon','place':'593'})
        self.lectures = self.lectures.append({'name':'キャリアガイダンス','max_students':100,'period':3,'weekday':'Mon','place':'講堂'})
        self.lectures = self.lectures.append({'name':'キャリアガイダンス','max_students':100,'period':4,'weekday':'Mon','place':'講堂'})
        #self.lectures = self.lectures.append({'name':'ICT演習','max_students':100,'period':4,'weekday':'Mon','place':'講堂'})
        #self.lectures = self.lectures.append({'name':'ICT演習','max_students':100,'period':5,'weekday':'Mon','place':'講堂'})
        #令和２年度後期
        #令和元年度前期
        #令和元年度後期
        #平成３０年度前期
        #平成30年度後期
        #-----------------------------

        #時間割データ--------------------
        self.periods = pd.DataFrame(columns=['start_time','end_time'])
        self.periods = self.periods.append({'start_time':'09:00','end_time':'10:30'})
        self.periods = self.periods.append({'start_time':'10:40','end_time':'12:10'})
        self.periods = self.periods.append({'start_time':'13:10','end_time':'14:40'})
        self.periods = self.periods.append({'start_time':'14:50','end_time':'16:20'})
        self.periods = self.periods.append({'start_time':'16:30','end_time':'18:00'})
        

        #------------------------------
        return
    
    def GenerateStudents():



