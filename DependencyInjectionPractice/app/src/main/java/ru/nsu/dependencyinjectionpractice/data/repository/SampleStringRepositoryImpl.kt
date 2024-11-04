package ru.nsu.dependencyinjectionpractice.data.repository

import ru.nsu.dependencyinjectionpractice.data.datasource.SampleStringDataSource
import ru.nsu.dependencyinjectionpractice.data.datasource.SampleStringLocalDataSource
import ru.nsu.dependencyinjectionpractice.data.datasource.SampleStringRemoteDataSource
import ru.nsu.dependencyinjectionpractice.domain.repository.SampleStringRepository

//TODO di
class SampleStringRepositoryImpl : SampleStringRepository {

	private val localDataSource: SampleStringDataSource = SampleStringLocalDataSource()
	private val remoteDataSource: SampleStringDataSource = SampleStringRemoteDataSource()

	override fun getFromRemote(): String =
		remoteDataSource.get()

	override fun getFromLocal(): String =
		localDataSource.get()
}