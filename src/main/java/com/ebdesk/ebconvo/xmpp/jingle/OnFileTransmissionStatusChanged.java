package com.ebdesk.ebconvo.xmpp.jingle;

import com.ebdesk.ebconvo.entities.DownloadableFile;

public interface OnFileTransmissionStatusChanged {
	public void onFileTransmitted(DownloadableFile file);

	public void onFileTransferAborted();
}
