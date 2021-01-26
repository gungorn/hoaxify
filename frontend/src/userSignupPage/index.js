import React from 'react';
import axios from 'axios';
import './index.css';
import * as API from '../API';

class UserSignupPage extends React.Component {
	state = {
		username: '',
		displayname: '',
		password: '',
		password2: '',
		agree: false,
		loading: false,
		validationErrors: {}
	};

	componentDidMount() { }
	componentDidUpdate(prevProps, prevState) { }
	componentWillUnmount() { }

	onChange = ({ target }) => {
		const { name, value } = target;
		const validationErrors = { ...this.state.validationErrors };
		delete validationErrors[name];

		this.setState({ [name]: value, validationErrors });
	};
	// onChangeUsername = ({ target }) => { this.setState({ username: target.value }); };
	// onChangeDisplayname = ({ target }) => { this.setState({ displayname: target.value }); };
	// onChangePassword = ({ target }) => { this.setState({ password: target.value }); };
	// onChangePassword2 = ({ target }) => { this.setState({ password2: target.value }); };
	// onChangeAgrement = ({ target }) => { this.setState({ agree: target.checked }); };


	onClickSignup = async d => {
		d.preventDefault();

		if (this.state.loading) return;
		this.setState({ loading: true });

		const res = await API.userSignUp(this.state);
		if (res.status) { //200 ok

		}
		else { //error
			console.log('RES', res.data.response.data);
			this.setState({ validationErrors: res.data.response.data.type === 'validerr' ? res.data.response.data.errors : {} });
		}

		this.setState({ loading: false });
	};

	render() {
		const { validationErrors } = this.state;

		return (
			<div className="container">
				<form>
					<h1>Signup Page</h1>

					<div className="mb-3">
						<label className="inputLabel">Username</label>
						<input
							className={validationErrors.username ? "form-control is-invalid" : "form-control"}
							name="username"
							value={this.state.username}
							onChange={this.onChange}
						/>
						<div className="invalid-feedback">{validationErrors.username}</div>
					</div>

					<div className="mb-3">
						<label className="inputLabel">Display Name</label>
						<input
							className={validationErrors.displayname ? "form-control is-invalid" : "form-control"}
							name="displayname"
							value={this.state.displayname}
							onChange={this.onChange}
						/>
						<div className="invalid-feedback">{validationErrors.displayname}</div>
					</div>

					<div className="mb-3">
						<label className="inputLabel">password</label>
						<input
							className={validationErrors.password ? "form-control is-invalid" : "form-control"}
							name="password"
							type="password"
							value={this.state.password}
							onChange={this.onChange}
						/>
						<div className="invalid-feedback">{validationErrors.password}</div>
					</div>

					<div className="mb-3">
						<label className="inputLabel">Repeat password</label>
						<input
							className="form-control"
							name="password2"
							type="password"
							value={this.state.password2}
							onChange={this.onChange}
						/>
					</div>


					<button
						type="button"
						className="btn btn-primary"
						data-bs-toggle="tooltip"
						data-bs-placement="top"
						title="Sign Up"
						disabled={this.state.loading}
						onClick={this.onClickSignup}
						style={{ width: '20%', height: "50px" }}
					>
						{
							this.state.loading ?
								<div className="spinner-border text-light" role="status">
									<span className="visually-hidden">Loading...</span>
								</div> :
								"Sign Up"
						}
					</button>
				</form>
			</div>
		);
	}
}

export { UserSignupPage };
