package pt.guilhermerodrigues.goodbarbercodechallenge.core.common

@Suppress("UNCHECKED_CAST")
interface UseCase<Type, Params> {
    suspend operator fun invoke(params: Params = Unit as Params): Type
}