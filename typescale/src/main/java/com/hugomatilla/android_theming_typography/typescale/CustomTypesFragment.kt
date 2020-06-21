package com.hugomatilla.android_theming_typography.typescale

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_custom.fab
import kotlinx.android.synthetic.main.fragment_custom.showMaterialDialog
import kotlinx.android.synthetic.main.fragment_custom.showMaterialMenu

class CustomTypesFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    contextThemeWrapper = ContextThemeWrapper(activity, R.style.Theme_MyApp_TypeScale)
    val localInflater = inflater.cloneInContext(contextThemeWrapper)

    return inflater.inflate(R.layout.fragment_custom, container, false)
  }

  var contextThemeWrapper: Context? = null

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    contextThemeWrapper?.let { context ->
      showMaterialDialog.setOnClickListener {
        MaterialAlertDialogBuilder(context).apply { this.setMessage("Dialog") }.show()
      }
      val popup = PopupMenu(contextThemeWrapper, showMaterialMenu)
      popup.menuInflater.inflate(R.menu.main, popup.menu)
      showMaterialMenu.setOnClickListener { popup.show() }
      fab.setOnClickListener { WidgetsActivity.start(activity!!) }
    }
  }

}
