package io.android.brewdogbeers.domain.usecase

internal interface UseCase<TParam, TResult> {

    suspend operator fun invoke(param: TParam): TResult
}
