package ru.nsu.dependencyinjectionpractice.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.nsu.dependencyinjectionpractice.domain.usecase.GetSampleStringFromLocalUseCase
import ru.nsu.dependencyinjectionpractice.domain.usecase.GetSampleStringFromRemoteUseCase

class MainViewModel : ViewModel() {

	//TODO di
	private val getSampleStringFromLocalUseCase: GetSampleStringFromLocalUseCase =
		GetSampleStringFromLocalUseCase()
	//TODO di
	private val getSampleStringFromRemoteUseCase: GetSampleStringFromRemoteUseCase =
		GetSampleStringFromRemoteUseCase()

	private val _state: MutableLiveData<MainState> = MutableLiveData<MainState>()
	val state: LiveData<MainState> = _state

	fun loadStrings() {
		_state.value = MainState.Loading

		val fromLocal = getSampleStringFromLocalUseCase()
		val fromRemote = getSampleStringFromRemoteUseCase()

		_state.value = MainState.Success(remoteString = fromRemote, localString = fromLocal)
	}
}