package ru.nsu.dependencyinjectionpractice.domain.usecase

import ru.nsu.dependencyinjectionpractice.data.repository.SampleStringRepositoryImpl
import ru.nsu.dependencyinjectionpractice.domain.repository.SampleStringRepository

class GetSampleStringFromRemoteUseCase {

	//TODO di
	private val repository: SampleStringRepository = SampleStringRepositoryImpl()

	operator fun invoke(): String {
		val fromRemote = repository.getFromRemote()
		val repoInstanceHash = repository.hashCode()

		return "$fromRemote, repo hash = $repoInstanceHash"
	}
}