package avila.daniel.calculator

import avila.daniel.calculator.schedulers.IScheduleProvider
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

object MockSchedulersImp : IScheduleProvider {
    override fun computation(): Scheduler = Schedulers.trampoline()

    override fun io(): Scheduler = Schedulers.trampoline()

    override fun ui(): Scheduler = Schedulers.trampoline()
}