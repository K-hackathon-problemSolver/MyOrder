package com.problemsolver.myorder.app.presentation.OrderChoiceCustom

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.problemsolver.myorder.app.domain.model.Category
import com.problemsolver.myorder.app.domain.model.Option
import com.problemsolver.myorder.app.domain.util.log
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderChoiceCustomViewModel @Inject constructor(

) :ViewModel() {

	private var _categories = mutableStateListOf(Category())
	val categories: SnapshotStateList<Category> = _categories

	fun addCategory(category: Category) {
		_categories.add(category)
	}

	fun addOption(index: Int) {
		val options = categories[index].getOptionList()
		options.add(Option())
		_categories[index] = categories[index].copy(options = options)
		_categories.add(Category())
		_categories.removeLast()
	}

	fun removeOption(categoryIdx: Int, optionIndex: Int) {
		val options = categories[categoryIdx].getOptionList()
		options.removeAt(optionIndex)
		_categories[categoryIdx] = categories[categoryIdx].copy(options = options)
		_categories.add(Category())
		_categories.removeLast()
	}

	fun onCategoryNameChanged(name: String, index: Int) {
		_categories[index] = categories[index].copy(
			categoryName = name
		)
	}

	fun onOptionChanged(name: String, categoryIdx: Int, optionIndex: Int) {
		val options = categories[categoryIdx].getOptionList()
		options[optionIndex].detail = name
		_categories[categoryIdx] = categories[categoryIdx].copy(options = options)
		_categories.add(Category())
		_categories.removeLast()

	}

	fun onPriceChanged(price: Int?, categoryIdx: Int, optionIndex: Int) {
		val options = categories[categoryIdx].getOptionList()
		options[optionIndex].price = price
		_categories[categoryIdx] = categories[categoryIdx].copy(options = options)
		_categories.add(Category())
		_categories.removeLast()
	}

	fun removeCategory(categoryIdx: Int) {
		_categories.removeAt(categoryIdx)
	}

}