import java.util.EventListener;

public interface PanelListener extends EventListener {
	public void PanelEventOccured(PanelEvent e);

	public void RestartEventOccured(PanelEvent pE);

}
