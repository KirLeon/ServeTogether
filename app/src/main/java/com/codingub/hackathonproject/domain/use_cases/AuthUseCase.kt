package com.codingub.hackathonproject.domain.use_cases

import com.codingub.hackathonproject.data.remote.requests.LoginDataRequest
import com.codingub.hackathonproject.data.remote.requests.RegisterDataRequest
import com.codingub.hackathonproject.data.repositories.AuthRepository
import com.codingub.hackathonproject.network.AuthResult
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: AuthRepository){

    suspend operator fun invoke(parameters: LoginDataRequest): AuthResult<Unit> {
        return repository.signIn(request = parameters)
    }
}

class RegisterUseCase @Inject constructor(private val repository: AuthRepository)  {

    suspend operator fun invoke(parameters: RegisterDataRequest): AuthResult<Unit> {
        return repository.signUp(request = parameters)
    }

}

class AuthUseCase @Inject constructor(private val repository: AuthRepository){

    suspend operator fun invoke(): AuthResult<Unit> {
        return repository.authenticate()
    }
}