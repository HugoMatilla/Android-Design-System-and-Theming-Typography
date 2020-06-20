package com.hugomatilla.android_theming_typography

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.hugomatilla.android_theming_typography.R.id
import com.hugomatilla.android_theming_typography.typescale.TypeScaleFragment
import kotlinx.android.synthetic.main.activity_main.bottomNavigation
import com.hugomatilla.android_theming_typography.typescale.CustomTypesFragment as CustomTypographyFragment

class MainActivity : AppCompatActivity() {

  private lateinit var customTypographyFragment: CustomTypographyFragment
  private lateinit var typeScaleFragment: TypeScaleFragment
  private lateinit var simpleFragment: SimpleFragment

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setupFragments()
    setupBottomNavigation()
  }

  private fun setupFragments() {
    simpleFragment = SimpleFragment()
    typeScaleFragment = TypeScaleFragment()
    customTypographyFragment = CustomTypographyFragment()

    supportFragmentManager.commit {
      add(id.fragment_container, customTypographyFragment, null)
      add(id.fragment_container, typeScaleFragment, null)
      add(id.fragment_container, simpleFragment, null)
    }

    simpleFragment.show()
  }

  private fun setupBottomNavigation() {
    bottomNavigation.setOnNavigationItemSelectedListener {
      when (it.itemId) {
        id.simple -> simpleFragment.show()
        id.list -> typeScaleFragment.show()
      }
      true
    }
  }

  private fun Fragment.show() {
    val fragment = this
    supportFragmentManager.commit { replace(R.id.fragment_container, fragment, null) }
  }

}
