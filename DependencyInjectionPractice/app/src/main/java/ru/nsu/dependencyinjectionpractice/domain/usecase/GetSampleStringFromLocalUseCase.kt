package ru.nsu.dependencyinjectionpractice.domain.usecase

import ru.nsu.dependencyinjectionpractice.data.repository.SampleStringRepositoryImpl
import ru.nsu.dependencyinjectionpractice.domain.repository.SampleStringRepository


class GetSampleStringFromLocalUseCase {

	//TODO di
	private val repository: SampleStringRepository = SampleStringRepositoryImpl()

	operator fun invoke(): String {
		val fromLocal = repository.getFromLocal()
		val repoInstanceHash = repository.hashCode()

		return "$fromLocal, repo hash = $repoInstanceHash"
	}
}