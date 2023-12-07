package BehavioralPattern

class MediaPlayer {
    private var state: State1 = StoppedState()

    fun setState(newState: State1) {
        state = newState
    }

    fun play() {
        state.play(this)
    }

    fun pause() {
        state.pause(this)
    }

    fun stop() {
        state.stop(this)
    }
}

interface State1 {
    fun play(player: MediaPlayer)
    fun pause(player: MediaPlayer)
    fun stop(player: MediaPlayer)
}
class PlayingState : State1 {

    override fun play(player: MediaPlayer) {
        println("Already playing...")
    }

    override fun pause(player: MediaPlayer) {
        println("Pausing the playback.")
        player.setState(PausedState())
    }

    override fun stop(player: MediaPlayer) {
        println("Stopping the playback.")
        player.setState(StoppedState())
    }
}

class PausedState : State1 {
    override fun play(player: MediaPlayer) {
        println("Resuming playback.")
        player.setState(PlayingState())
    }

    override fun pause(player: MediaPlayer) {
        println("Already paused...")
    }

    override fun stop(player: MediaPlayer) {
        println("Stopping the playback.")
        player.setState(StoppedState())
    }
}

class StoppedState : State1 {
    override fun play(player: MediaPlayer) {
        println("Starting playback.")
        player.setState(PlayingState())
    }

    override fun pause(player: MediaPlayer) {
        println("Cannot pause, the player is stopped.")
    }

    override fun stop(player: MediaPlayer) {
        println("Already stopped...")
    }
}

fun main() {
    val mediaPlayer = MediaPlayer()

    mediaPlayer.play()   // Output: Starting playback.
    mediaPlayer.pause()  // Output: Pausing the playback.
    mediaPlayer.play()   // Output: Resuming playback.
    mediaPlayer.stop()   // Output: Stopping the playback.
}

