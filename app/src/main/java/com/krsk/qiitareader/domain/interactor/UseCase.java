package com.krsk.qiitareader.domain.interactor;

import android.support.annotation.NonNull;
import android.util.Log;

import com.krsk.qiitareader.domain.executor.PostExecutionThread;
import com.krsk.qiitareader.domain.executor.ThreadExecutor;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by bl-lia on 2/1/16.
 */
public abstract class UseCase<T> {

    protected final ThreadExecutor threadExecutor;
    protected final PostExecutionThread postExecutionThread;

    protected abstract Observable<T> buildUseCaseObservable();

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    public void execute(@NonNull UseCaseSubscriber<T> subscriber) {
        final Observable<T> observable =
                this.buildUseCaseObservable()
                    .subscribeOn(Schedulers.from(threadExecutor))
                    .observeOn(postExecutionThread.getScheduler());

        observable.subscribe(subscriber);
    }

    public static abstract class UseCaseSubscriber<V> extends rx.Subscriber<V> {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(UseCase.class.getSimpleName(), "Error", e);
        }

        @Override
        public void onNext(V v) {

        }
    }
}
