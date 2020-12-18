#!/usr/bin/python
# -*- coding: utf-8 -*-

"""
モデルを作る
"""
import xgboost as xgb

class Model:

    def __init__(self):
        train = pd.DataFrame(columns=['location','time','students'])
        for i in ['2018_Late','2018_Pre','2019_Late','2019_Pre','2020_Late','2020_Pre']:


    def training(self,X_train,Y_train)
        reg = xgb.XGBRegressor(n_estimators=50)
        reg.fit(X_train, y_train,) 