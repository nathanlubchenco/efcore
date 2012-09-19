package com.weaselworks.util.state;

/**
 *  Represents a transition from one {@link weaselworks.state.State} to another in a {@link weaselworks.state.StateMachine}. </p>
 *
 *  A {@link weaselworks.state.Transition} has a list of {@link weaselworks.state.TransitionListener TransitionListeners} that are
 *  notified each time a {@link weaselworks.state.StateMachine} traverses that {@link weaselworks.state.Transition}.
 *
 *  @see weaselworks.state.StateMachine
 *  @see weaselworks.state.State
 */

public class Transition
{
    /**
     *
     * @param startState
     * @param endState
     */

    public
    Transition (final State startState, final State endState)
    {
        setStartState (startState);
        setEndState (endState);
        return;
    }

    protected State startState;

    public
    State getStartState ()
    {
        return this.startState;
    }

    protected
    void setStartState (final State startState)
    {
        this.startState = startState;
        return;
    }

    protected State endState;

    public
    State getEndState ()
    {
        return this.endState;
    }

    protected
    void setEndState (final State endState)
    {
        this.endState = endState;
        return;
    }

    /**
     *  @see java.lang.Object#toString
     */

    public
    String toString ()
    {
        String s = getClass ().getName () + "[";
        s += "startState=" + getStartState ();
        s += ",endState=" + getEndState ();
        return s + "]";
    }

    protected TransitionListenerSupport listeners;

    public
    void addTransitionListener (final TransitionListener ler)
    {
        if (listeners == null) {
            listeners = new TransitionListenerSupport ();
        }
        listeners.addListener (ler);
        return;
    }

    public
    void removeTransitionListener (final TransitionListener ler)
    {
        if (listeners != null) {
            listeners.removeListener (ler);
        }
        return;
    }

    protected
    void notifyTransitionListeners (final TransitionEvent tevt)
    {
        if (listeners != null) {
            listeners.perform (tevt);
        }
        return;
    }
}

// EOF