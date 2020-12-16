package com.yeahoohunters.avoavo.back

import android.app.job.JobParameters
import android.app.job.JobService
import android.widget.Toast

class MJobService: JobService() {
    override fun onStopJob(p0: JobParameters?): Boolean {
        return false
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        return true
    }
}