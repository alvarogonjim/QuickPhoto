package aiss.model.resources;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLEncoder;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Map;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.representation.InputRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;
import aiss.model.google.drive.Parent;
import aiss.model.google.drive.UserPermission;
import aiss.model.google.drive.about.About;

public class GoogleDriveResource {
	private static final Logger log = Logger.getLogger(GoogleDriveResource.class.getName());

	private String uri = "https://www.googleapis.com/drive/v2/files";
	private String access_token;
	private String uri_upload = "https://www.googleapis.com/upload/drive/v2/files";
	private String uri_about = "https://www.googleapis.com/drive/v2/about";

	public GoogleDriveResource(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * 
	 * @return Files
	 */
	public Files getFiles() {
		ClientResource cr = null;
		Files files = null;
		try {
			cr = new ClientResource(uri + "?access_token=" + access_token);
			String result = cr.get(String.class);
			files = cr.get(Files.class);

		} catch (ResourceException re) {
			log.warning("Error when retrieving all files: " + cr.getResponse().getStatus());
		}

		return files;
	}

	public About getAbout() {
		ClientResource cr = null;
		About info = null;
		try {
			cr = new ClientResource(uri_about + "?access_token=" + access_token);
			info = cr.get(About.class);
		} catch (ResourceException re) {
			log.warning("Error when retrieving file: " + cr.getResponse().getStatus());
		}
		return info;
	}

	public boolean moveFile(String fileId, String parentId) throws UnsupportedEncodingException {
		ClientResource cr = null;
		boolean res = true;
		try {
			// POST https://www.googleapis.com/drive/v2/files/fileId/parents
			String cid = URLEncoder.encode(fileId, "UTF-8");
			cr = new ClientResource(uri + "/" + cid + "/parents?access_token=" + access_token);
			Parent p = new Parent();
			p.setId(parentId);
			cr.post(p);

		} catch (ResourceException re) {
			log.warning("Error when retrieving all files: " + cr.getResponse().getStatus());
			res = false;
		}

		return res;
	}

	public FileItem getFile(String id) {

		ClientResource cr = null;
		FileItem file = null;
		try {
			cr = new ClientResource(uri + "/" + id + "?access_token=" + access_token);
			file = cr.get(FileItem.class);

		} catch (ResourceException re) {
			log.warning("Error when retrieving file: " + cr.getResponse().getStatus());
		}

		return file;

	}

	public String insertFile(FileItem file, String content) {

		ClientResource cr = null;
		String newId = null;
		try {
			cr = new ClientResource(uri + "?access_token=" + access_token);
			FileItem newFile = cr.post(file, FileItem.class);
			newId = newFile.getId();
			cr = new ClientResource(uri_upload + "/" + newId + "?uploadType=media&access_token=" + access_token);
			Map<String, Object> headers = cr.getRequestAttributes();
			headers.put("Content-Type", "image/jpg");
			headers.put("Content-Length", content.length());
			cr.put(content);
		} catch (ResourceException re) {
			log.warning("Error when inserting file: " + cr.getResponse().getStatus());
		}
		return newId;
	}

	public String insertFile(FileItem file, byte[] content) {

		ClientResource cr = null;
		String newId = null;
		try {
			cr = new ClientResource(uri + "?access_token=" + access_token);
			FileItem newFile = cr.post(file, FileItem.class);
			newId = newFile.getId();
			cr = new ClientResource(uri_upload + "/" + newId + "?uploadType=media&access_token=" + access_token);
			Map<String, Object> headers = cr.getRequestAttributes();
			headers.put("Content-Type", "image/jpg");
			// headers.put("Content-Length", content.length());
			cr.getRequest().setEntity(
					new InputRepresentation(new ByteArrayInputStream(content), MediaType.APPLICATION_OCTET_STREAM));
			cr.put("");
		} catch (ResourceException re) {
			log.warning("Error when inserting file: " + cr.getResponse().getStatus());
		}
		return newId;
	}

	public boolean updateFile(FileItem file) {

		ClientResource cr = null;
		boolean result = true;
		try {
			cr = new ClientResource(uri + "/" + file.getId() + "?access_token=" + access_token);
			cr.put(file);
		} catch (ResourceException re) {
			log.warning("Error when updating file: " + cr.getResponse().getStatus());
			result = false;
		}
		return result;
	}

	public boolean updatePermissions(String id) {
		ClientResource cr = null;
		boolean res = false;
		try {

			UserPermission up = new UserPermission();
			up.setRole("writer");
			up.setType("anyone");
			FileItem file = this.getFile(id);
			cr = new ClientResource(file.getSelfLink() + "/permissions/?access_token=" + access_token);
			file.setUserPermission(up);
			UserPermission newFile = cr.post(up, UserPermission.class);
			res = true;
		} catch (ResourceException re) {
			log.warning("Error when inserting file: " + cr.getResponse().getStatus());
		}
		return res;
	}

	public boolean deleteFile(String id) {

		ClientResource cr = null;
		boolean result = true;
		try {
			cr = new ClientResource(uri + "/" + id + "?access_token=" + access_token);
			cr.delete();
		} catch (ResourceException re) {
			log.warning("Error when deleting file: " + cr.getResponse().getStatus());
			result = false;
		}
		return result;

	}

	public String getFileContent(FileItem item) {
		String result = null;
		String contentURL = item.getDownloadUrl();
		try {
			ClientResource cr = new ClientResource(contentURL);
			/*
			 * Map<String, Object> reqAttribs = cr.getRequestAttributes();
			 * Series<Header> headers =
			 * (Series<Header>)reqAttribs.get("org.restlet.http.headers"); if
			 * (headers == null) { headers = new Series<Header>(Header.class);
			 * reqAttribs.put("org.restlet.http.headers", headers); }
			 * headers.add(new Header("Authorization:",
			 * "Bearer "+access_token));
			 */
			ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
			chr.setRawValue(access_token);
			cr.setChallengeResponse(chr);

			result = cr.get(String.class);
		} catch (ResourceException re) {
			log.warning("Error when obtaining content of file: " + item.getId());
		}
		return result;
	}

	public boolean updateFileContent(String id, String content) {
		ClientResource cr = new ClientResource(uri_upload + "/" + id + "?uploadType=media");
		try {
			ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
			chr.setRawValue(access_token);
			cr.setChallengeResponse(chr);
			StringRepresentation rep = new StringRepresentation(content, MediaType.IMAGE_ALL);
			cr.put(rep);
		} catch (ResourceException re) {
			log.warning("Error when updating the content of file: " + id);
			log.warning(re.getMessage());
			return false;
		}
		return true;
	}

}
