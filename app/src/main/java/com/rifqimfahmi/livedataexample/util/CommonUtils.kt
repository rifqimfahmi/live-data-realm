package com.rifqimfahmi.livedataexample.util

import android.support.v4.app.FragmentManager
import com.rifqimfahmi.livedataexample.dialog.CommonLoadingDialog

class CommonUtils {
    companion object {
        fun showLoadingDialog(fm: FragmentManager, message: String?): CommonLoadingDialog {
            val commonDialog: CommonLoadingDialog = CommonLoadingDialog.newInstance(message)
            commonDialog.show(fm, CommonLoadingDialog.TAG)
            return commonDialog
        }
    }
}