package avila.daniel.calculator.di

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import avila.daniel.calculator.di.qualifiers.ForActivity
import avila.daniel.calculator.di.qualifiers.ForApplication
import avila.daniel.calculator.domain.CalcImp
import avila.daniel.calculator.domain.ICalc
import avila.daniel.calculator.domain.interactor.AddUseCase
import avila.daniel.calculator.domain.interactor.DivisionUseCase
import avila.daniel.calculator.domain.interactor.MultiplyUseCase
import avila.daniel.calculator.domain.interactor.SubtractUseCase
import avila.daniel.calculator.schedulers.IScheduleProvider
import avila.daniel.calculator.schedulers.ScheduleProviderImp
import avila.daniel.calculator.ui.MainActivityViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single(ForApplication) { androidContext() }
}

val activityModule = module {
    lateinit var activityReference: AppCompatActivity
    factory { (activity: AppCompatActivity) -> activityReference = activity }
    factory<Context>(ForActivity) { activityReference }
    factory<Activity> { activityReference }
}

val viewModelModule = module {
    viewModel { MainActivityViewModel(get(), get(), get(), get(), get()) }
}

val useCaseModule = module {
    factory { AddUseCase(get()) }
    factory { DivisionUseCase(get()) }
    factory { MultiplyUseCase(get()) }
    factory { SubtractUseCase(get()) }
}

val scheduleModule = module {
    single<IScheduleProvider> { ScheduleProviderImp() }
}

val calcModule = module {
    single<ICalc> { CalcImp() }
}
